package com.yash.pim.main;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.yash.pim.model.Category;
import com.yash.pim.model.Item;
import com.yash.pim.service.CategoryService;
import com.yash.pim.service.ItemService;
import com.yash.pim.serviceimpl.CategoryServiceImpl;
import com.yash.pim.serviceimpl.ItemServiceImpl;
import com.yash.pim.util.ApplicationUtil;

public class StartupApplication {

	
	private static CategoryService categoryService = new CategoryServiceImpl();
	private static ItemService itemService = new ItemServiceImpl();
	
	private static Scanner sc;
	
	public static void main(String[] args) {

		sc = new Scanner(System.in);
		

		while (true) {
			ApplicationUtil.printMenu();
			System.out.println("Enter your option: ");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				getCategoryFromUser();
				break;
			case 2:
				listCategoryAddedByUser();
				break;
			case 3: 
				deleteCategoryByRowNumber();
				break;
			case 4: 
				updateCategoryByRowNumber();
				break;
			case 5:
				System.out.println("-----adding item------");
				getItemFromUser();
				break;
			case 6:
				listItemAddedByUser();
				
				break;
			case 0:
				ApplicationUtil.exit();
			}
			
			ApplicationUtil.pressAnyKeyToContinue();

		}
	}
	
	private static void listItemAddedByUser() {
		System.out.println("----Listing Item----");
		List<Item> items = itemService.listItem();
		System.out.println("item id       \t     category id  \t item name \t item cost \t purchase date");
		System.out.println("==============================================================================");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		for(int i = 0; i < items.size(); i++) {
			Item item = items.get(i);
			System.out.println((i+1)+". " 
			+ item.getId() 
			+ "   -   "
			+ item.getCategoryId() 
			+ "   -   "
			+ item.getName()
			+ "   -   "
			+ item.getCost()
			+ "   -   "
			+ 
			sdf.format(item.getPurchaseDate()));
					
		}
	}
	
	private static void getItemFromUser() {
		if(categoryService.listCategory().isEmpty()){
			System.out.println("There are no categories, please add a category first");
		} else {
			listCategoryAddedByUser();
			System.out.println("Enter the list number of the category that the item belongs to :");
			int position = sc.nextInt();
			Category category = categoryService.listCategory().get(position - 1);
			
			category.getId();
			
			Item item = new Item();
			
			System.out.println("Enter the name of the item :");
			sc.nextLine();
			item.setName(sc.nextLine());
			
			System.out.println("Enter the cost of the item: ");
			item.setCost(sc.nextDouble());
			
			item.setPurchaseDate(new Date());
			item.setCategoryId(category.getId());
			
			itemService.insertItem(item);
			
		}
		
	}

	private static void updateCategoryByRowNumber() {
		System.out.println("editing category");
		listCategoryAddedByUser();
		System.out.println("Please Enter the list number of the category you want to delete: ");
		
		int position =sc.nextInt();
		
		System.out.println("Enter the new category name: ");
		sc.nextLine();
		
		String newName = sc.nextLine();
		
		categoryService.updateCategory(position-1, newName);
		
		System.out.println("Success! Category updated...");
		
		
		
	}

	private static void deleteCategoryByRowNumber() {
		System.out.println("---deleting categories by id---");
		listCategoryAddedByUser();
		
		System.out.println("Please Enter the list number of the category you want to delete: ");
		int position = sc.nextInt();
		
		Category categoryToBeDeleted = categoryService.listCategory().get(position - 1);
		categoryService.deleteCategory(categoryToBeDeleted.getId());
		
		System.out.println("Success! Category deleted...");
	}

	private static void listCategoryAddedByUser() {
		System.out.println("----listing categories----");
		List<Category> catList = categoryService.listCategory();
		for(int i =0; i < catList.size(); i++) {
			Category category = catList.get(i);
			System.out.println((i+1)+". "+category.getName()+" - "+category.getId());

		}
	}

	private static void getCategoryFromUser() {
		sc.nextLine();
		System.out.println("------adding category------");
		System.out.println("Enter Category Name : ");
		String catName = sc.nextLine();
		Category category = new Category();
		category.setName(catName);
		categoryService.addCategory(category);
		
		System.out.println("Success! Category delete...");
	}

}
