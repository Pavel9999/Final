package by.epam.task05.controller.command.impl;

import by.epam.task05.controller.command.Command;
import by.epam.task05.controller.command.util.CreatorFullURL;
import by.epam.task05.entity.Car;
import by.epam.task05.entity.UserRole;
import by.epam.task05.logger.MyLogger;
import by.epam.task05.service.CarService;
import by.epam.task05.service.ClientService;
import by.epam.task05.service.ServiceProvider;
import com.sun.deploy.net.HttpRequest;
import com.sun.org.apache.bcel.internal.generic.SWITCH;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

public class AddCarCommand implements Command
{
    public static final String COMMAND = "add_car";

    private static final String DEFAULT_PAGE = "/WEB-INF/views/default.jsp";
    private static final String GUEST_PAGE = "/WEB-INF/views/default.jsp";
    private static final String CLIENT_PAGE = "/WEB-INF/views/client_cars.jsp";
    private static final String MANAGER_PAGE = "/WEB-INF/views/manager_cars.jsp";
    private static final String ADMIN_PAGE = "/WEB-INF/views/admin_cars.jsp";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response){

        HttpSession session;
        String email;
        UserRole role;
        String url;
        String page;
        List<Car> cars;

        session = request.getSession(true);

        request.setAttribute("prev_command", COMMAND);
        if (request.getParameterMap().containsKey("local")) {
            String newLocale = request.getParameter("local");
            session = request.getSession(true);
            session.setAttribute("local", newLocale);
        }

        email = (String)session.getAttribute("email");
        role = UserRole.createRole((String)session.getAttribute("role")) ;
        url = CreatorFullURL.create(request);
        session.setAttribute("prev_request", url);

        ServiceProvider provider = ServiceProvider.getInstance();
        CarService service = provider.getCarService();



        String brand = request.getParameter("brand");
        String model = request.getParameter("model");
        String img = request.getParameter("img");
        String color = request.getParameter("color");
        String year = request.getParameter("year");
        String price = request.getParameter("price");

        Car car = new Car();
        car.setBrand(brand);
        car.setModel(model);
        car.setImg(img);
        car.setColor(color);
        car.setYear(year);
        car.setPrice(Float.parseFloat(price));
        service.AddCar(car);



        cars = service.selectAllCars();
        request.setAttribute("cars", cars);

        List<List<Car>> carRows = getCarRows(cars);
        request.setAttribute("car_rows", carRows);


        String date = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 3);
        String date1 = new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
        request.setAttribute("date_start_fill", date);
        request.setAttribute("date_finish_fill", date1);

        switch (role)
        {
            case GUEST:{
                page = GUEST_PAGE;
            }break;
            case CLIENT:{
                page = CLIENT_PAGE;
                request.setAttribute("full_name", session.getAttribute("full_name"));
            }break;
            case MANAGER:{
                page = MANAGER_PAGE;
                request.setAttribute("full_name", session.getAttribute("full_name"));
            }break;
            case ADMIN:{
                page = ADMIN_PAGE;
                request.setAttribute("full_name", session.getAttribute("full_name"));
            }break;
            default: {
                page = DEFAULT_PAGE;
            }break;
        }


        RequestDispatcher dispatcher = request.getRequestDispatcher(page);

        try {
            dispatcher.forward(request, response);
        }
        catch (Exception e)
        {
            System.out.println(e);
            MyLogger.getInstance().error(e);
        }
    }

    public List<Car> getCars(List<Car> cars, String page_number, int productsOnPage)
    {
        List<Car> new_cars  = new LinkedList<>();


        int pagesCount = cars.size() / productsOnPage;
        if (cars.size() % productsOnPage != 0) pagesCount++;
        int pn = Integer.valueOf(page_number);
        if (pn <= pagesCount) // сравнивает с числом округлённым в бОльшую сторону
        {
            new_cars = cars.subList((pn-1)*productsOnPage, Math.min(pn*productsOnPage, cars.size()));
        }
        else
        {
            pn = 1;
            new_cars = cars.subList((pn-1)*productsOnPage, Math.min(pn*productsOnPage, cars.size()));
        }

        return new_cars;
    }

    public int getPagesCount(List<Car> cars, int productsOnPage) {
        int pagesCount = cars.size() / productsOnPage;
        if (cars.size() % productsOnPage != 0) pagesCount++;

        return pagesCount;
    }


    private List<List<Car>> getCarRows(List<Car> cars)
    {
        List<List<Car>> result = new LinkedList<>();

        for(int i=0; i < cars.size(); i++)
        {
            if (i%3 == 0) result.add(new LinkedList<Car>());

            result.get(result.size()-1).add(cars.get(i));
        }

        return result;
    }

}
