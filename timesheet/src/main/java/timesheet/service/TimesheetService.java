package timesheet.service;

import java.util.List;

import timesheet.model.Employee;
import timesheet.model.WeekSheet;

public interface TimesheetService {

    WeekSheet getWeekSheetByDate(String date, Employee employee, String projectName);

    boolean saveWeekSheet(Employee employee, String projectName, String startDate, List<Integer> hours);

    boolean unsubmitWeekSheet(String dateString, Employee employee, String projectName);

    boolean approveWeekSheet(String dateString, Employee employee, String projectName);

    boolean disapproveWeekSheet(String dateString, Employee employee, String projectName);
}