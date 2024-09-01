package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.text.View;

import model.Client;
import model.InitApp;
import model.Owner;
import view.MyFrame;

public class Control implements ActionListener {
	private InitApp init;
	private MyFrame view;

	public Control() throws FileNotFoundException {
		init = new InitApp();
		view = new MyFrame(this, init.getInfoEnt(), init.getImgList(), init.getListDesserts(), init.generateDataDesserts(), init.getTitlesList(), init.getTotals());
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand();
		switch (command) {
		case "start":
			view.change("1");
			break;
		case "products":
			view.change("2");
			break;
		case "logIn":
			view.logIn(this);
			break;
		case "accept":
			view.changeTextBtnLogIn(view.getNameUser());
			if(view.getNameUser().equals(init.getOwner().getNameUser())) {
				init.setOwner(new Owner());
				view.setVisibleBtnClient(false);
				view.setVisibleBtnOwner(true);
			} else {
				init.setClient(new Client(view.getNameUser()));
				view.setVisibleBtnOwner(false);
				view.setVisibleBtnClient(true);
			}
			view.close();
			break;
		case "cancel":
			view.close();
			break;
		case "addProduct":
			view.change("3");
			break;
		case "deleteProduct":
			view.change("4");
			break;
		case "editProduct":
			view.change("5");
			break;
		case "addDessert":
			try {
				init.getOwner().addDessert(view.getIdProd(), view.getNameProd(), view.getPriceProd(), view.getQuantityProd(), view.getUrlImageProd(), view.getDescriptionProd());
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			break;
		case "acceptEdit":
			try {
				init.getOwner().editDessert(view.getDessertName(), view.getAtributeChange(), view.getValueChange());
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			break;
		case "acceptDelete":
			try {
				init.getOwner().deleteDessert(view.getDessertDelete());
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			break;
		case "buyDessert":
			view.showBill(init.getInfoEnt(), init.getClient(), init.getClient().calculateTotal(view.returnDessertShop(init.getListDesserts())), view.returnDessertShop(init.getListDesserts()), this);
			try {
				init.getOwner().editShopRecord(view.returnDessertShop(init.getListDesserts()));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			view.change("1");
			break;
		case "showInventary":
			view.change("6");
			break;
		case "showShopRecord":
			view.change("7");
			break;
		case "AcceptBill":
			try {
				view.closeBill();
				view.closeFrame();
				new Control();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			break;
		default:
			break;
		}
	}
}
