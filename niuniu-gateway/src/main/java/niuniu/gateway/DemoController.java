package niuniu.gateway;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import niuniu.jpa.object.Customer;
import niuniu.jpa.repo.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/niuniu/demo")
@Api(description = "demo接口", produces = "application/json")
public class DemoController {
    final private static Logger logger = LoggerFactory.getLogger(DemoController.class);

  @Autowired
  private CustomerRepository customerRepository;

  @ApiOperation(value = "customer register", response = Customer.class)
  @PostMapping(path="/customer-register", consumes = "application/json")
  @ResponseStatus(HttpStatus.CREATED)
  public Customer customerRegister(@ApiParam(value = "customer") @RequestBody Customer customer) {
    return this.customerRepository.save(customer);
  }
}
