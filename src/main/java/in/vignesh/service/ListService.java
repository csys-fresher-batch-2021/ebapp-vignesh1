package in.vignesh.service;

import java.util.List;


import in.vignesh.dao.PriceListDAO;
import in.vignesh.exception.DBException;
import in.vignesh.exception.RegistrationValidationException;
import in.vignesh.exception.ServiceException;
import in.vignesh.model.Unit;
import in.vignesh.validator.AddListValidation;


public class ListService {

	private ListService()
	{
		
	}
	
	
	public static boolean addList(Unit unit) {
		boolean isAdded = false;
		try {
			if(AddListValidation.validList(unit)){
				PriceListDAO dao=new PriceListDAO();
				dao.addList(unit);
				isAdded=true;
			}
		} catch (DBException| RegistrationValidationException e) {
			throw new ServiceException("unable to add");
		}
		return isAdded;
		
	}
	public static List<Unit> showAllList() {
		PriceListDAO dao = new PriceListDAO();
		return dao.getAllList();
	}
	
	public static boolean existingAdd(Unit unit)
	{
		boolean isMatched=false;
			try {
				PriceListDAO dao = new PriceListDAO();
				List<Unit> getList=dao.getAllList();
				for (Unit up : getList) {

					if (up.getMinUnit()==(unit.getMinUnit())
							&& up.getMaxUnit()==(unit.getMaxUnit())
							&& up.getPrice()==(unit.getPrice())){
						isMatched = true;
						break;

					}
				}
			} catch (DBException e) {
				throw new ServiceException("unable to fetch userdetail in database");
			}
			return isMatched;
	}
}
