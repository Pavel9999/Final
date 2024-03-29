package by.epam.task05.dao.impl;

import by.epam.task05.dao.CarDAO;
import by.epam.task05.dao.DaoException;
import by.epam.task05.entity.Car;
import by.epam.task05.logger.MyLogger;
import javafx.util.Pair;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class SQLCarDAO extends SqlDao implements CarDAO {

    private static final String SELECT_CARS_WITH_ID = "SELECT * FROM car WHERE `id_car`=?";
    private static final String SELECT_ALL_CARS = "SELECT * FROM car";
    private static final String SELECT_CARS_CONTRACT_ID = "SELECT * FROM car WHERE `id_contract`=?";
    private static final String SET_CONTRACT_ID = "UPDATE car SET `id_contract`=? WHERE `id_car`=?";
    private static final String INSERT_CAR_CREDENTIONALS = "INSERT INTO car (`id_car`, `rental`, `id_contract`, `id_class_car`, `brand`, `model`, `year`, `mkp`, `color`, `horsepower`, `engine_size`, `miliage`, `price`, `img`) Values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    @Override
    public List<Car> selectAllCars() throws DaoException
    {
        List<Car> cars = new LinkedList<>();
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try{
            con = ConnectionPool.getInstance().getConnection();
            statement = con.prepareStatement(SELECT_ALL_CARS);
            resultSet = statement.executeQuery();

            while(resultSet.next()){

                Car newCar = createCar(resultSet);

                cars.add(newCar);
            }

            ConnectionPool.getInstance().releaseConnection(con);

        }
        catch(Exception e){
            System.out.println(e);
            MyLogger.getInstance().error(e);
            throw new DaoException(e);
        }
        finally {
            close(resultSet, statement);
        }

        return cars;
    }

    @Override
    public List<Car> selectFreeCars() throws DaoException
    {
        List<Car> cars = new LinkedList<>();
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try{
            con = ConnectionPool.getInstance().getConnection();

            statement = con.prepareStatement(SELECT_CARS_CONTRACT_ID);
            statement.setInt(1, 0);
            resultSet = statement.executeQuery();

            while(resultSet.next()){

                Car newCar = createCar(resultSet);

                cars.add(newCar);
            }

            ConnectionPool.getInstance().releaseConnection(con);

        }
        catch(Exception e){
            System.out.println(e);
            MyLogger.getInstance().error(e);
            throw new DaoException(e);
        }
        finally {
            close(resultSet, statement);
        }

        return cars;
    }

    @Override
    public Car selectCar(int car_id) throws DaoException
    {
        Car car = null;
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try{
            con = ConnectionPool.getInstance().getConnection();

            statement = con.prepareStatement(SELECT_CARS_WITH_ID);
            statement.setInt(1, car_id);
            resultSet = statement.executeQuery();

            if(resultSet.next()){

                car = createCar(resultSet);

            }

            ConnectionPool.getInstance().releaseConnection(con);
        }
        catch(Exception e){
            System.out.println(e);
            MyLogger.getInstance().error(e);
            throw new DaoException(e);
        }
        finally {
            close(resultSet, statement);
        }

        return car;
    }

    @Override
    public void setContractID(int idCar, int idContract) throws DaoException
    {
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try{
            con = ConnectionPool.getInstance().getConnection();

            statement = con.prepareStatement(SET_CONTRACT_ID);
            statement.setInt(1, idContract);
            statement.setInt(2, idCar);

            try
            {
                statement.executeUpdate();
            }
            catch (SQLException e) {
                System.out.println(e);
                MyLogger.getInstance().error(e);
                throw new DaoException(e);
            }

            ConnectionPool.getInstance().releaseConnection(con);

        }
        catch(Exception e){
            System.out.println(e);
            MyLogger.getInstance().error(e);
            throw new DaoException(e);
        }
        finally {
            close(resultSet, statement);
        }
    }

    @Override
    public void AddCar(Car car) throws DaoException {
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try{
            con = ConnectionPool.getInstance().getConnection();

            statement = con.prepareStatement(INSERT_CAR_CREDENTIONALS);
            statement.setInt(1, getNextCarID());
            statement.setString(2, car.getRental());
            statement.setInt(3, car.getContract_id());
            statement.setInt(4, 1);
            statement.setString(5, car.getBrand());
            statement.setString(6, car.getModel());
            statement.setInt(7, Integer.parseInt(car.getYear()));
            statement.setString(8, car.getMkp());
            statement.setString(9, car.getColor());
            statement.setString(10, car.getHorsepower());
            statement.setString(11, car.getEngine_size());
            statement.setString(12, car.getMiliage());
            statement.setFloat(13, car.getPrice());
            statement.setString(14, car.getImg());

            try
            {
                statement.executeUpdate();
            }
            catch (SQLException e) {
                System.out.println(e);
                MyLogger.getInstance().error(e);
                throw new DaoException(e);
            }

            ConnectionPool.getInstance().releaseConnection(con);

        }
        catch(Exception e){
            System.out.println(e);
            MyLogger.getInstance().error(e);
            throw new DaoException(e);
        }
        finally {
            close(resultSet, statement);
        }

    }


    private Car createCar(ResultSet resultSet) throws DaoException  {
        Car newCar = new Car();

        try {
            int id = resultSet.getInt(1);
            String rental = resultSet.getString(2);
            int id_contract = resultSet.getInt(3);
            int id__class_car = resultSet.getInt(4);
            String brand = resultSet.getString(5);
            String model = resultSet.getString(6);
            String year = resultSet.getString(7);
            String mkp = resultSet.getString(8);
            String color = resultSet.getString(9);
            String horsePower = resultSet.getString(10);
            String engineSize = resultSet.getString(11);
            String miliage = resultSet.getString(12);
            float price = resultSet.getFloat(13);
            String img = resultSet.getString(14);

            newCar.setId(id);
            newCar.setRental(rental);
            newCar.setContract_id(id_contract);
            newCar.setBrand(brand);
            newCar.setModel(model);
            newCar.setYear(year);
            newCar.setMkp(mkp);
            newCar.setColor(color);
            newCar.setHorsepower(horsePower);
            newCar.setEngine_size(engineSize);
            newCar.setMiliage(miliage);
            newCar.setPrice(price);
            newCar.setImg(img);
        }catch(Exception e){
            System.out.println(e);
            MyLogger.getInstance().error(e);
            throw new DaoException(e);
        }


        return newCar;
    }

    private void close(ResultSet rs, PreparedStatement st) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
            MyLogger.getInstance().error(e);
        }
        try {
            if (st != null) {
                st.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
            MyLogger.getInstance().error(e);
        }
    }

    int getNextCarID()
    {
        int id = 0;
        Connection con = null;
        PreparedStatement st= null;
        ResultSet rs = null;

        try {
            con = DriverManager.getConnection(url, login, password);
            String sqlRequest = "SELECT COUNT(*) FROM car";
            st = con.prepareStatement(sqlRequest);
            rs = st.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1) + 1;
            }

            ConnectionPool.getInstance().releaseConnection(con);

        } catch (Exception e) {
            System.out.println(e);
            MyLogger.getInstance().error(e);
        }
        finally {
            close(rs, st);
        }


        return id;
    }
}
