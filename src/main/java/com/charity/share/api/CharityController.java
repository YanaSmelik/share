package com.charity.share.api;

import com.charity.share.model.Charity;
import com.charity.share.service.CharityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RequestMapping("/share")
@Controller
public class CharityController {

  @Autowired
  private CharityServiceImpl charityService;


  @PostMapping("/charities/charity")
  public String addCharity(@RequestBody Charity charity){
    charityService.save(charity);

    return "addForm";
  }

  @GetMapping("charities") // DONE
  public String listCharities(Model model){
    List<Charity> charities = charityService.findAll();
    model.addAttribute("charities", charities);
    return "charities";
  }

  @GetMapping("charities/{id}") // DONE
  public String findCharityById(@PathVariable("id") Integer id, Map<String, Object> model){
    Charity charity = charityService.findById(id);
    model.put("charity", charity);
    return "details";
  }

  @DeleteMapping("charities/{id}")
  public void deleteCharity(@PathVariable("id") Integer id){
    Charity charity = charityService.findById(id);
    charityService.delete(charity);
  }

  @PutMapping("charities/{id}")
  public void updateCharity(@PathVariable("id") Long id,
                            @Valid @NotNull @RequestBody Charity charity){
    charityService.update(charity);
  }
}
