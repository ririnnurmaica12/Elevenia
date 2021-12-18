package com.elevenia;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteProduct {
        WebDriver driver = new ChromeDriver();
        DeleteProductHelper deleteProductHelper;

        public DeleteProduct() {
            this.deleteProductHelper = new DeleteProductHelper(this.driver);
        }

        @Given("^Access web elevenia$")
        public void access_web_elevenia() {
            this.deleteProductHelper.access_web();
        }

        @When("^Search keyword \"(.*?)\"$")
        public void Search_keyword(String keyword) throws Throwable {
            this.deleteProductHelper.search_keyword(keyword);
        }

        @When("^Select category product terlaris$")
        public void select_category_product_terlaris() throws Throwable {
            this.deleteProductHelper.select_category_product_terlaris();
        }

        @When("^Select first product in page$")
        public void select_first_product_in_page() throws Throwable {
            this.deleteProductHelper.select_first_product_in_page();
        }

        @When("^Update \"(.*?)\" product$")
        public void update_product(String QTY) throws Throwable {
            this.deleteProductHelper.update_product(QTY);
        }

        @When("^Direct to cart page$")
        public void direct_to_cart_page() throws Throwable {
            this.deleteProductHelper.direct_to_cart_page();
        }

        @When("^Change courier$")
        public void change_courier() throws Throwable {
            this.deleteProductHelper.change_courier();
        }

        @When("^Cancel change courier$")
        public void cancel_change_courier() throws Throwable {
            this.deleteProductHelper.cancel_change_courier();
        }

        @When("^Delete product in the cart$")
        public void delete_product_in_the_cart() throws Throwable {
            this.deleteProductHelper.delete_product_in_the_cart();
        }

        @Then("^Should be \"(.*?)\" and \"(.*?)\"$")
        public void should_be(String Result, String ExpectMsg) throws Throwable {
            this.deleteProductHelper.should_be(ExpectMsg, Result);
        }
}