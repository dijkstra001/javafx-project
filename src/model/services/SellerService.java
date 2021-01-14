package model.services;

import java.util.List;

import gui.util.Alerts;
import javafx.scene.control.Alert.AlertType;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Seller;

public class SellerService {
	
	private SellerDao dao = DaoFactory.createSellerDao();
	
	public List<Seller> findAll() {
		return dao.findAll();
	}
	
	public void saveOrUpdate(Seller entity) {
		if (entity.getId() == null) {
			dao.insert(entity);
		}
		else {
			dao.update(entity);
		}
		Alerts.showAlert("Data changed completed", null, "The data was updated or add in the data base.", AlertType.INFORMATION);
	}
	
	public void remove(Seller obj) {
		dao.deleteById(obj.getId());
	}
}
