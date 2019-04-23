package com.msm.msmserver;

import java.util.List;

import com.msm.dao.BillDao;
import com.msm.dao.CardDao;
import com.msm.dao.EmployeeDao;
import com.msm.dao.GreensDao;
import com.msm.dao.TuserDao;
import com.msm.dao.impl.BillDaoImpl;
import com.msm.dao.impl.CardDaoImpl;
import com.msm.dao.impl.EmployeeDaoImpl;
import com.msm.dao.impl.GreensDaoImpl;
import com.msm.dao.impl.TuserDaoImpl;
import com.msm.domain.Bill;
import com.msm.domain.CanTing;
import com.msm.domain.Employee;
import com.msm.domain.Greens;
import com.msm.domain.Tuser;

import junit.framework.TestCase;


/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    public void insertTuser(){
    	TuserDao t=new TuserDaoImpl();
    	System.out.println(t.insertTuser(new Tuser(6, "赵虎", 0, 1)));
    }
    public void freezeTuser(){
    	TuserDao t=new TuserDaoImpl();
    	System.out.println(t.freezeTuser(3));
    }
    public void findTuser(){
    	TuserDao t=new TuserDaoImpl();
    	System.out.println(t.findTuserName("add"));
    }
    public void findTuserID(){
    	TuserDao t=new TuserDaoImpl();
    	System.out.println(t.findTuser(5));
    }
    public void isfreeze(){
    	TuserDao t=new TuserDaoImpl();
    	System.out.println(t.isfreeze(3));
    }
    public void getSeq(){
    	TuserDao t=new TuserDaoImpl();
    	System.out.println(t.getSeq());
    }
    //"--------------------------------------------------------------"
    public void insertEmployee(){
    	EmployeeDao e=new EmployeeDaoImpl();
    	Employee ee=new Employee(10,2,"王五","55555");
    	boolean a = e.insertEmployee(ee);
    	System.out.println(a);

    }
    public void removeEmployee(){
    	EmployeeDao e=new EmployeeDaoImpl();
    	System.out.println(e.removeEmployee(5));
    }
    public void findMaName(){
    	EmployeeDao e=new EmployeeDaoImpl();
    	System.out.println(e.findMaName(1));
    }
    public void findAllEmp(){
    	EmployeeDao e=new EmployeeDaoImpl();
    	List<Employee> list = e.findAllEmp();
    	for (Employee a : list) {
    		System.out.println(a.getEid()+"----"+a.getEname());
		}
    	
    }
    public void findByMagr(){
    	EmployeeDao e=new EmployeeDaoImpl();
    	List<Employee> list = e.findByMagr(1);
    	for (Employee a : list) {
    		System.out.println(a.getEid()+"----"+a.getEname());
		}
    	
    }
    //||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
    public void openCard(){
    	CardDao c=new CardDaoImpl();
    	System.out.println(c.openCard(3));
    }
    public void FindCardId(){
    	CardDao c=new CardDaoImpl();
    	System.out.println(c.findCardId(2));
    }
    public void FindBal(){
    	CardDao c=new CardDaoImpl();
    	System.out.println(c.findBal(2));
    }
    public void ChangBal(){
    	CardDao c=new CardDaoImpl();
    	System.out.println(c.changeCard(2, 100));
    }
    public void losscard(){
    	CardDao c=new CardDaoImpl();
    	System.out.println(c.lossCard(2));
    }
    public void isloss(){
    	CardDao c=new CardDaoImpl();
    	System.out.println(c.isloss(3));
    }
    public void alivecard(){
    	CardDao c=new CardDaoImpl();
    	System.out.println(c.aliveCard(2));
    }
    //_________________________________________________
    public void findEmp(){
    	EmployeeDao e=new EmployeeDaoImpl();
    	System.out.println(e.findEmployee(2));
    	System.out.println(e.findManager(1));
    }
    public void findLoc(){
    	EmployeeDao e=new EmployeeDaoImpl();
    	System.out.println(e.findLoc(3));
    }
    //_________________________________________________
    public void insertBill(){
    	BillDao b=new BillDaoImpl();
    	System.out.println(b.insertBill(new Bill(2, 2, 1002, 300, "天津")));
    }
    public void findCT(){
    	BillDao b=new BillDaoImpl();
    	List<CanTing> list = b.findCT();
    	for (CanTing c : list) {
			System.out.println(c.getLoc()+"亚惠餐厅,总收入为："+c.getZprice());
		}
    }
    public void serviceTuser(){
    	BillDao b=new BillDaoImpl();
    	System.out.println(b.serviceTuser(1));
    }
    public void sumMoeny(){
    	BillDao b=new BillDaoImpl();
    	System.out.println(b.sumMoney(1));
    }
    //_________________________________________________
    public void insertGreens(){
    	GreensDao g=new GreensDaoImpl();
    	System.out.println(g.insertGreens(new Greens(0, "麻婆豆腐", 15, 15, 0, 1, 1)));
    }
    public void updateVolume(){
    	GreensDao g=new GreensDaoImpl();
    	System.out.println(g.alterVolume(1));
    }
}
