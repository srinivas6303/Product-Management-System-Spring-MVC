package com.example.PMS_SPRING_MVC;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    ProductServices ps;

    @GetMapping("/")
    public String display() {
        System.out.println("display method is called!");
        return "index.jsp";
    }

    
    @PostMapping("/add")
    public String add(@ModelAttribute Product p, Model model) {
        ps.addProduct(p);
        model.addAttribute("message", "PRODUCT IS ADDED!");

        //printing proper output
        StringBuilder output = new StringBuilder();
        output.append("Product Name: ").append(p.getName()).append("<br>")
                .append("Type: ").append(p.getType()).append("<br>")
                .append("Place: ").append(p.getPlace()).append("<br>")
                .append("Warranty: ").append(p.getWarrenty()).append("<br><br>");

        model.addAttribute("output", output.toString());
        return "result.jsp";
    }

    @GetMapping("/getAll")
    public String getAll(Model model) {
        model.addAttribute("message", "ALL PRODUCTS!");

        List<Product> list = ps.getAllProducts();
        if (list.isEmpty()) {
            model.addAttribute("output", "LIST IS EMPTY!");
        } else {
            StringBuilder output = new StringBuilder();
            for (Product product : list) {
                output.append("Product Name: ").append(product.getName()).append("<br>")
                        .append("Type: ").append(product.getType()).append("<br>")
                        .append("Place: ").append(product.getPlace()).append("<br>")
                        .append("Warranty: ").append(product.getWarrenty()).append("<br><br>");
            }
            model.addAttribute("output", output.toString());
        }
        return "result.jsp";
    }

    @GetMapping("/getByName")
    public String getByName(@RequestParam("name") String name, Model model) {
        model.addAttribute("message", "PRODUCT BY NAME");
        List<Product> list = ps.getProductByName(name);
        StringBuilder output = new StringBuilder();

        if (!list.isEmpty()) {
            for (Product product : list) {
                output.append("Product Name: ").append(product.getName()).append("<br>")
                        .append("Type: ").append(product.getType()).append("<br>")
                        .append("Place: ").append(product.getPlace()).append("<br>")
                        .append("Warranty: ").append(product.getWarrenty()).append("<br><br>");
            }
            model.addAttribute("output", output.toString());
        } else {
            String str = "Product not found with this name: " + name;
            model.addAttribute("output", str);
        }
        return "result.jsp";
    }


    @GetMapping("/getByPlace")
    public String getByPlace(@RequestParam("place") String place, Model model) {
        model.addAttribute("message", "PRODUCTS BY PLACE");
        List<Product> list = ps.getProductByPlace(place);
        StringBuilder output = new StringBuilder();

        if (!list.isEmpty()) {
            for (Product product : list) {
                output.append("Product Name: ").append(product.getName()).append("<br>")
                        .append("Type: ").append(product.getType()).append("<br>")
                        .append("Place: ").append(product.getPlace()).append("<br>")
                        .append("Warranty: ").append(product.getWarrenty()).append("<br><br>");
            }
            model.addAttribute("output", output.toString());
        } else {
            String str = "Product not found at this place: " + place;
            model.addAttribute("output", str);
        }
        return "result.jsp";
    }


    //@DeleteMapping("/deleteByName") ->HTML does not support the DELETE method; it only supports GET and POST methods.
    @PostMapping("/deleteByName")
    public String deleteByName(@RequestParam("name") String name, Model model) {
        model.addAttribute("message", "DELETED PRODUCT BY NAME");

            String str=ps.deleteProductByName(name);
            model.addAttribute("output", str);
        return "result.jsp";
    }

    //@DeleteMapping("/deleteByName") ->HTML does not support the DELETE method; it only supports GET and POST methods.
    @PostMapping("/deleteAll")
    public String deleteAll(Model model) {
        model.addAttribute("message", "DELETED ALL PRODUCT ");

        String str= ps.deleteAllProducts();
        model.addAttribute("output", str);
        return "result.jsp";
    }

    @GetMapping("/outWarrenty")
    public String outWarrenty(@RequestParam("year") int year, Model model) {
        model.addAttribute("message", "OUT OF WARRANTY PRODUCTS");
        List<Product> list = ps.outOfWarrenty(year);

        StringBuilder output = new StringBuilder();
        if (list.isEmpty()) {
            model.addAttribute("output", "List is empty!");
        } else {
            for (Product product : list) {
                output.append("Product Name: ").append(product.getName()).append("<br>")
                        .append("Type: ").append(product.getType()).append("<br>")
                        .append("Place: ").append(product.getPlace()).append("<br>")
                        .append("Warranty: ").append(product.getWarrenty()).append("<br><br>");
            }
            model.addAttribute("output", output.toString());
        }
        return "result.jsp";
    }


    @GetMapping("/findSubString")
    public String findSubString(@RequestParam("text") String text, Model model) {
        model.addAttribute("message", "MATCHED SUBSTRING PRODUCCTS!");
        List<Product> list = ps.findBySubString(text);
        StringBuilder output = new StringBuilder();
        if (list.isEmpty()) {
            String str = "No product is Matched with this SubString: " + text;
            model.addAttribute("output", str);
        } else {
            for (Product product : list) {
                output.append("Product Name: ").append(product.getName()).append("<br>")
                        .append("Type: ").append(product.getType()).append("<br>")
                        .append("Place: ").append(product.getPlace()).append("<br>")
                        .append("Warranty: ").append(product.getWarrenty()).append("<br><br>");
            }
            model.addAttribute("output", output.toString());
        }
        return "result.jsp";
    }

    @PostMapping("/updateProduct")
    public String updateProduct(@RequestParam("name") String name,@ModelAttribute Product p,Model model){
        model.addAttribute("message","UPDATED PRODUCT BY NAME");
        String str=ps.updateProductByName(name,p);
        model.addAttribute("output",str);
        return "result.jsp";
    }


}


