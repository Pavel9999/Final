package by.epam.task05.controller.command;

import by.epam.task05.controller.command.impl.*;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
	
	private Map<String, Command> commands = new HashMap<>();
	
	public CommandProvider() {
		commands.put(AddCarCommand.COMMAND, new AddCarCommand());
		commands.put(AddUserCommand.COMMAND, new AddUserCommand());
		commands.put("all_cars", new AllCarsCommand());
		commands.put(AllClientsCommand.COMMAND, new AllClientsCommand());
		commands.put(AllManagersCommand.COMMAND, new AllManagersCommand());
		commands.put("all_contracts", new AllContractsCommand());
		commands.put("authorization", new AuthorizationCommand());
		commands.put("cancel_rent", new CancelRentCommand());
		commands.put("change_locale", new ChangeLocale());
		commands.put("client_contracts", new ClientContractsCommand());
		commands.put("confirm_rent", new ConfirmRentCommand());
		commands.put("enterAsGuest", new EnterAsGuestCommand());
		commands.put("finish_rent", new FinishRentCommand());
		commands.put("free_cars", new FreeCarsCommand());
		commands.put("go_to_add_car", new GoToAddCarCommand());
		commands.put("go_to_add_user", new GoToAddUserCommand());
		commands.put("goToAuthorizationPage", new GoToAuthorizationCommand());
		commands.put("go_to_index", new GoToIndexPageCommand());
		commands.put("goToRegistrationPage", new GoToRegistrationCommand());
		commands.put("logout", new LogoutCommand());
		commands.put("manager_contracts", new ManagerContractsCommand());
		commands.put("registration", new RegistrationCommand());
		commands.put("start_rent", new StartRentCommand());
		commands.put("unconfirmed_contracts", new UnconfirmedContractsCommand());
	}
	
	public Command getCommand(String commandName) {
		return commands.get(commandName);
	}

}
