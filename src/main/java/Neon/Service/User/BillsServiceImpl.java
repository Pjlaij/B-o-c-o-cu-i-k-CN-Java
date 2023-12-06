package Neon.Service.User;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Neon.DAO.BillsDAO;
import Neon.DTO.CartDTO;
import Neon.Entity.BillDetail;
import Neon.Entity.Bills;

@Service
public class BillsServiceImpl implements iBillsService {
	@Autowired
	private BillsDAO billsDAO;

	public int AddBills(Bills bill) {
		return billsDAO.AddBills(bill);
	}


	public void AddBillsDetail(HashMap<Long, CartDTO> carts) {
		long idBills = billsDAO.GetIDLastBills();
		for (Map.Entry<Long, CartDTO> itemcart:carts.entrySet()) {
			BillDetail billDetail = new BillDetail();
			billDetail.setId_bills(idBills);
			billDetail.setId_product(itemcart.getValue().getProduct().getId_product());
			billDetail.setQuanty(itemcart.getValue().getQuanty());
			billDetail.setTotal(itemcart.getValue().getTotalPrice());
			billsDAO.AddBillsDetail(billDetail);
		}
	}

}
