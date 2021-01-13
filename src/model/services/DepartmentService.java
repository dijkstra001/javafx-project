package model.services;

import java.util.List;

import gui.util.Alerts;
import javafx.scene.control.Alert.AlertType;
import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentService {
	
	private DepartmentDao dao = DaoFactory.createDepartmentDao();
	
	public List<Department> findAll() {
		return dao.findAll();
	}
	
	public void saveOrUpdate(Department entity) {
		if (entity.getId() == null) {
			dao.insert(entity);
		}
		else {
			dao.update(entity);
		}
		Alerts.showAlert("Data changed completed", null, "The data was updated or add in the data base.", AlertType.INFORMATION);
	}
}
