package com.example.bespoked;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
  @Autowired
  private ProductRepository productRepository;
  @Autowired
  private SalepersonRepository salepersonRepository;
  @Autowired
  private CustomerRepository customerRepository;
  @Autowired
  private SaleRepository saleRepository;

  @GetMapping(path="/reports")
  public ModelAndView reports() {
    ModelAndView modelAndView = new ModelAndView("reports");
    Iterable<Sale> reports = saleRepository.findByQuarterlySale();
    modelAndView.addObject("reports", reports);
    return modelAndView;
  }


  @GetMapping(path="/products")
  public ModelAndView products() {
    ModelAndView modelAndView = new ModelAndView("products");
    Iterable<Product> allProduct = productRepository.findAll();
    modelAndView.addObject("allProduct", allProduct);
    return modelAndView;
  }

  @GetMapping(path="/saleperson")
  public ModelAndView saleperson() {
    ModelAndView modelAndView = new ModelAndView("saleperson");
    Iterable<Saleperson> allSaleperson = salepersonRepository.findAll();
    modelAndView.addObject("allSaleperson", allSaleperson);
    return modelAndView;
  }

  @GetMapping(path="/customer")
  public ModelAndView customer() {
    ModelAndView modelAndView = new ModelAndView("customer");
    Iterable<Customer> allCustomer = customerRepository.findAll();
    modelAndView.addObject("allCustomer", allCustomer);
    return modelAndView;
  }

  @GetMapping(path="/sale")
  public ModelAndView sale() {
    ModelAndView modelAndView = new ModelAndView("sale");
    Iterable<Sale> allSale = saleRepository.findAll();
    modelAndView.addObject("allSale", allSale);
    return modelAndView;
  }

  @GetMapping(path="/addproduct")
  public String addProduct(Model model) {
    model.addAttribute("product", new Product());
    return "addproduct";
  }

  @PostMapping("/addproduct")
  public String addProductSubmit(@ModelAttribute Product product, Model model) {
    Product p = new Product();
    p.setName(product.getName());
    p.setQty(product.getQty());
    p.setCommissionPercentage(product.getCommissionPercentage());
    p.setManufacturer(product.getManufacturer());
    p.setPurchasePrice(product.getPurchasePrice());
    p.setSalePrice(product.getSalePrice());
    p.setStyle(product.getStyle());
    productRepository.save(p);
    return "addproduct";
  }

  @GetMapping(path="/addsaleperson")
  public String addSaleperson(Model model) {
    model.addAttribute("saleperson", new Saleperson());
    return "addsaleperson";
  }

  @PostMapping("/addsaleperson")
  public String addSalepersonSubmit(@ModelAttribute Saleperson saleperson, Model model) {
    Saleperson sp = new Saleperson();
    sp.setId(saleperson.getId());
    sp.setFirstName(saleperson.getFirstName());
    sp.setLastName(saleperson.getLastName());
    sp.setAddress(saleperson.getAddress());
    sp.setPhone(saleperson.getPhone());
    sp.setStartDate(saleperson.getStartDate());
    sp.setTerminationDate(saleperson.getTerminationDate());
    sp.setManager(saleperson.getManager());
    salepersonRepository.save(sp);
    return "addsaleperson";
  }

  @GetMapping(path="/addsale")
  public String addSale(Model model) {
    model.addAttribute("sale", new Sale());
    return "addsale";
  }

  @PostMapping("/addsale")
  public String addSaleSubmit(@ModelAttribute Sale sale, Model model) {
    Sale s = new Sale();
    s.setId(sale.getId());
    s.setProduct(sale.getProduct());
    s.setSaleperson(sale.getSaleperson());
    s.setCustomer(sale.getCustomer());
    s.setSaleDate(sale.getSaleDate());
    s.setPrice(sale.getPrice());
    s.setCommission(sale.getCommission());
    saleRepository.save(s);
    return "addsale";
  }

}