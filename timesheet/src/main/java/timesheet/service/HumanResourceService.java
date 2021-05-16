package timesheet.service;

import java.util.List;

import timesheet.model.Employee;
import timesheet.model.Manager;
import timesheet.model.User;

public interface HumanResourceService {

    Manager getCurrentManager();

    Long registerNewEmployee(User user);

    Employee getEmployeeByUsername(String employeeName);

    Employee getEmployeeByRealName(String name);

    List<String> getEmployeeNameListByProjectName(String projectName);
}