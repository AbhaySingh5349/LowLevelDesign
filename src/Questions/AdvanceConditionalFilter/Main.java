package Questions.AdvanceConditionalFilter;

import Questions.AdvanceConditionalFilter.dto.FilterCondition;
import Questions.AdvanceConditionalFilter.dto.ProductFilterSystem;
import Questions.AdvanceConditionalFilter.enums.Operator;
import Questions.AdvanceConditionalFilter.enums.ProductAttribute;
import Questions.AdvanceConditionalFilter.enums.SizeAttribute;
import Questions.AdvanceConditionalFilter.model.Product;
import Questions.AdvanceConditionalFilter.strategy.filter.*;
import Questions.AdvanceConditionalFilter.strategy.filter_expression.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Product nikeShoes = new Product("Nike", "Shoes", 120.0, 4.5, "Red", SizeAttribute.L, true);
        Product adidasShoes = new Product("Adidas", "Shoes", 150.0, 4.7, "Black", SizeAttribute.M, true);
        Product pumaShoes = new Product("Puma", "Shoes", 110.0, 4.3, "Blue", SizeAttribute.S, true);
        Product reebokShoes = new Product("Reebok", "Shoes", 150.0, 4.0, "Black", SizeAttribute.L, true);
        List<Product> products = List.of(nikeShoes, adidasShoes, pumaShoes, reebokShoes);

        // EQUALS: Exact match
        FilterCondition equalsCondition = new FilterCondition(ProductAttribute.BRAND, Operator.EQUALS, "Nike");

        // CONTAINS: Substring match
        FilterCondition containsCondition = new FilterCondition(ProductAttribute.BRAND, Operator.CONTAINS, "di");

        // STARTS_WITH: Starts with a specific prefix
        FilterCondition startsWithCondition = new FilterCondition(ProductAttribute.BRAND, Operator.STARTS_WITH, "Ad");

        // ENDS_WITH: Ends with a specific suffix
        FilterCondition endsWithCondition = new FilterCondition(ProductAttribute.BRAND, Operator.ENDS_WITH, "ma");

        // IN: List of valid brands
        FilterCondition inCondition = new FilterCondition(ProductAttribute.BRAND, Operator.IN, List.of("Nike", "Puma"));

        ProductFilterSystem filterSystem = new ProductFilterSystem(List.of(new BrandFilter()));

        System.out.println(filterSystem.evaluateProduct(nikeShoes, equalsCondition)); // true
        System.out.println(filterSystem.evaluateProduct(adidasShoes, containsCondition)); // true
        System.out.println(filterSystem.evaluateProduct(adidasShoes, startsWithCondition)); // true
        System.out.println(filterSystem.evaluateProduct(pumaShoes, endsWithCondition)); // true
        System.out.println(filterSystem.evaluateProduct(pumaShoes, inCondition)); // true

        System.out.println("*******************************************************");

        /*
        // Conditions for different product attributes
        FilterCondition brandCondition = new FilterCondition(ProductAttribute.BRAND, Operator.IN, List.of("Nike", "Adidas"));
        FilterCondition priceCondition = new FilterCondition(ProductAttribute.PRICE, Operator.LESS_THAN, 130.0);
        FilterCondition colorCondition = new FilterCondition(ProductAttribute.COLOR, Operator.EQUALS, "Black");

        // Wrapping Conditions in Expressions
        BrandFilter brandFilter = new BrandFilter();
        PriceFilter priceFilter = new PriceFilter();
        ColorFilter colorFilter = new ColorFilter();

        ConditionExpression brandExpression = new ConditionExpression(brandFilter, brandCondition);
        ConditionExpression priceExpression = new ConditionExpression(priceFilter, priceCondition);
        ConditionExpression colorExpression = new ConditionExpression(colorFilter, colorCondition);

        // Creating complex logical filter expressions
        ProductFilterExpression andExpression = new AndFilterExpression(brandExpression, priceExpression);  // (brand AND price)
        ProductFilterExpression orExpression = new OrFilterExpression(andExpression, colorExpression);  // ((brand AND price) OR color)
        ProductFilterExpression notExpression = new NotFilterExpression(priceExpression);  // NOT price

        for (Product product : products) {
            System.out.println("Product: " + product.getBrand());
            System.out.println("Matches AND Expression: " + andExpression.evaluate(product));
            System.out.println("Matches OR Expression: " + orExpression.evaluate(product));
            System.out.println("Matches NOT Expression: " + notExpression.evaluate(product));
        }
         */

        System.out.println("*******************************************************");

        // Define Conditions
        FilterCondition brandCondition = new FilterCondition(ProductAttribute.BRAND, Operator.IN, List.of("Nike", "Adidas"));
        FilterCondition priceCondition = new FilterCondition(ProductAttribute.PRICE, Operator.LESS_THAN, 130.0);
        FilterCondition colorCondition = new FilterCondition(ProductAttribute.COLOR, Operator.EQUALS, "Black");

        // Create corresponding filter expressions
        BrandFilter brandFilter = new BrandFilter();
        PriceFilter priceFilter = new PriceFilter();
        ColorFilter colorFilter = new ColorFilter();

        ConditionExpression brandExpression = new ConditionExpression(brandFilter, brandCondition);
        ConditionExpression priceExpression = new ConditionExpression(priceFilter, priceCondition);
        ConditionExpression colorExpression = new ConditionExpression(colorFilter, colorCondition);

        // Complex Expression (AND and OR)
        ProductFilterExpression andExpression = new AndFilterExpression(brandExpression, priceExpression);  // (brand AND price)
        ProductFilterExpression orExpression = new OrFilterExpression(andExpression, colorExpression);  // ((brand AND price) OR color)

        IProductFilter productFilter = new ProductFilterImpl();
        List<Product> filteredProducts = productFilter.filter(products, orExpression);

        // Display filtered products
        filteredProducts.forEach(product -> System.out.println(product.getBrand() + " - " + product.getColor() + " - " + product.getPrice()));

    }
}
