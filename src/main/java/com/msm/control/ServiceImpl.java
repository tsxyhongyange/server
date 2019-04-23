package com.msm.control;

import java.util.List;

import com.msm.biz.BillBiz;
import com.msm.biz.CardBiz;
import com.msm.biz.EmployeeBiz;
import com.msm.biz.GreensBiz;
import com.msm.biz.TuserBiz;
import com.msm.biz.impl.BillBizImpl;
import com.msm.biz.impl.CardBizImpl;
import com.msm.biz.impl.EmployeeBizImpl;
import com.msm.biz.impl.GreensBizImpl;
import com.msm.biz.impl.TuserBizImpl;
import com.msm.dao.impl.BillDaoImpl;
import com.msm.domain.Bill;
import com.msm.domain.CanTing;
import com.msm.domain.Employee;
import com.msm.domain.Greens;
import com.msm.domain.Tuser;

public class ServiceImpl implements Service {
	BillBiz bb;
	CardBiz cb;
	EmployeeBiz eb;
	GreensBiz gb;
	TuserBiz tb;
	
	public ServiceImpl() {
		super();
		this.bb=new BillBizImpl();
		this.cb =new CardBizImpl();
		this.eb = new EmployeeBizImpl();
		this.gb = new GreensBizImpl();
		this.tb = new TuserBizImpl();
	}

	@Override
	public String addBill(Bill b) {
		// TODO Auto-generated method stub
		return this.bb.addBill(b);
	}

	@Override
	public List<Bill> selectBill(int userid) {
		// TODO Auto-generated method stub
		return this.bb.selectBill(userid);
	}

	@Override
	public List<CanTing> findCT() {
		// TODO Auto-generated method stub
		return this.bb.findCT();
	}

	@Override
	public String bopenCard(int userid) {
		// TODO Auto-generated method stub
		return this.cb.bopenCard(userid);
	}

	@Override
	public double selectBal(int userid) {
		// TODO Auto-generated method stub
		return this.cb.selectBal(userid);
	}

	@Override
	public String selectCard(int userid) {
		// TODO Auto-generated method stub
		return this.cb.selectCard(userid);
	}

	@Override
	public int selectCardId(int userid) {
		// TODO Auto-generated method stub
		return this.cb.selectCardId(userid);
	}

	@Override
	public String blossCard(int userid) {
		// TODO Auto-generated method stub
		return this.cb.blossCard(userid);
	}

	@Override
	public String baliveCard(int userid) {
		// TODO Auto-generated method stub
		return this.cb.baliveCard(userid);
	}

	@Override
	public String bchangeCard(int userid, int cardbal) {
		// TODO Auto-generated method stub
		return this.cb.bchangeCard(userid, cardbal);
	}

	@Override
	public String bisloss(int userid) {
		// TODO Auto-generated method stub
		return this.cb.bisloss(userid);
	}

	@Override
	public String addEmployee(Employee e) {
		// TODO Auto-generated method stub
		return this.eb.addEmployee(e);
	}

	@Override
	public String deleteEmployee(int eid) {
		// TODO Auto-generated method stub
		return this.eb.deleteEmployee(eid);
	}

	@Override
	public Employee selectEmployee(int eid) {
		// TODO Auto-generated method stub
		return this.eb.selectEmployee(eid);
	}

	@Override
	public String selectManager(int mgr) {
		// TODO Auto-generated method stub
		return this.eb.selectManager(mgr);
	}

	@Override
	public String selectLoc(int eid) {
		// TODO Auto-generated method stub
		return this.eb.selectLoc(eid);
	}

	@Override
	public String addGreens(Greens g) {
		// TODO Auto-generated method stub
		return this.gb.addGreens(g);
	}

	@Override
	public String updatePrice(int gid, int price) {
		// TODO Auto-generated method stub
		return this.gb.updatePrice(gid, price);
	}

	@Override
	public String updatePriced(int gid, int priced) {
		// TODO Auto-generated method stub
		return this.gb.updatePriced(gid, priced);
	}

	@Override
	public String delete(int gid) {
		// TODO Auto-generated method stub
		return this.gb.delete(gid);
	}

	@Override
	public List<Greens> welGreens() {
		// TODO Auto-generated method stub
		return this.gb.welGreens();
	}

	@Override
	public List<Greens> selectGreens() {
		// TODO Auto-generated method stub
		return this.gb.selectGreens();
	}

	@Override
	public Greens selectGreensById(int gid) {
		// TODO Auto-generated method stub
		return this.gb.selectGreensById(gid);
	}

	@Override
	public String addTuser(Tuser t) {
		// TODO Auto-generated method stub
		return this.tb.addTuser(t);
	}

	@Override
	public String updateTuser(Tuser t, int mtype) {
		// TODO Auto-generated method stub
		return this.tb.updateTuser(t, mtype);
	}

	@Override
	public String bfreezeTuser(int userid) {
		// TODO Auto-generated method stub
		return this.tb.bfreezeTuser(userid);
	}

	@Override
	public Tuser selectTuser(int userid) {
		// TODO Auto-generated method stub
		return this.tb.selectTuser(userid);
	}

	@Override
	public Tuser selectTuserName(String uname) {
		// TODO Auto-generated method stub
		return this.tb.selectTuserName(uname);
	}

	@Override
	public String bisfreeze(int userid) {
		// TODO Auto-generated method stub
		return this.tb.bisfreeze(userid);
	}

	@Override
	public String selectMaName(int eid) {
		// TODO Auto-generated method stub
		return this.eb.selectMaName(eid);
	}

	@Override
	public int selectMaxId() {
		// TODO Auto-generated method stub
		return this.tb.selectMaxId();
	}

	@Override
	public void updateVolume(int gid) {
		this.gb.updateVolume(gid);
		
	}

	@Override
	public List<Employee> selectAllEmp() {
		
		return this.eb.selectAllEmp();
	}

	@Override
	public List<Employee> selectByMagr(int magr) {
		// TODO Auto-generated method stub
		return this.eb.selectByMagr(magr);
	}

	@Override
	public int serviceBill(int eid) {
		// TODO Auto-generated method stub
		return this.bb.serviceBill(eid);
	}

	@Override
	public double salMoney(int eid) {
		// TODO Auto-generated method stub
		return this.bb.salMoney(eid);
	}

}
