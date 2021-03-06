package timesheet.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import timesheet.model.WeekSheet;

public interface WeekSheetRepository extends JpaRepository<WeekSheet, Long> {

    @SuppressWarnings("unchecked")
    WeekSheet save(WeekSheet weekSheet);

    @Query("select s from WeekSheet s where s.startDate = :date "
            + "and s.employee.employeeId = :empId and s.project.projectId = :projId")
    WeekSheet findByStartDateAndEmployeeIdAndProjectId(@Param("date") Date startDate,
            @Param("empId") long empId, @Param("projId") long projId);
}
