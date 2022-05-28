package com.jpetstore.product.app.product;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jpetstore.product.domain.model.Category;
import com.jpetstore.product.domain.model.Item;
import com.jpetstore.product.domain.model.Product;
import com.jpetstore.product.domain.service.catalog.CatalogService;

@RestController
public class ProductController {

	@Inject
	protected CatalogService catalogService;

	@RequestMapping("/pause")
	public boolean pause() {
		return catalogService.pause();
	}

	@RequestMapping("/resume")
	public boolean resume() {
		return catalogService.resume();
	}

	@RequestMapping("/categories")
	public Iterable<Category> getCategoryList() {

		return catalogService.getCategoryList();
	}

	@RequestMapping("/categories/{categoryId}")
	public Category getCategory(@PathVariable String categoryId) {

		return catalogService.getCategory(categoryId);
	}

	@RequestMapping("/products/{productId}")
	public Product getProduct(@PathVariable String productId) {

		return catalogService.getProduct(productId);
	}

	@RequestMapping("/categories/{categoryId}/products")
	public Iterable<Product> getProductListByCategory(@PathVariable String categoryId) {

		return catalogService.getProductListByCategory(categoryId);
	}

	@RequestMapping("/products")
	public Iterable<Product> searchProductList(@RequestParam String keywords) {

		return catalogService.searchProductList(keywords);
	}

	@RequestMapping("/products/{productId}/items")
	public Iterable<Item> getItemListByProduct(@PathVariable String productId) {

		return catalogService.getItemListByProduct(productId);
	}

	@RequestMapping("/items/{itemId}")
	public Item getItem(@PathVariable String itemId) {

		return catalogService.getItem(itemId);
	}

	@RequestMapping("/items/{itemId}/instock")
	public boolean isItemInStock(@PathVariable String itemId) {

		return catalogService.isItemInStock(itemId);
	}

	@RequestMapping(value = "/items/{itemId}/inventory", method = RequestMethod.POST)
	public void updateInventoryQuantity(@PathVariable String itemId, @RequestBody Item item) {

		catalogService.updateInventoryQuantity(item);
	}

	@RequestMapping(value = "/items/{itemId}/inventory", method = RequestMethod.GET)
	public int getInventoryQuantity(@PathVariable String itemId) {

		return catalogService.getInventoryQuantity(itemId);
	}
}
