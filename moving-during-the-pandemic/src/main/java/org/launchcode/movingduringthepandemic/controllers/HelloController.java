package org.launchcode.movingduringthepandemic.controllers;

import org.json.JSONObject;
import org.launchcode.movingduringthepandemic.models.Json;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class HelloController {

    @RequestMapping(value = "")
    public String displayForm(Model model) {
        model.addAttribute("title", "Driving During the Pandemic");
        return "index";
    }

    @PostMapping(value = "")
    public String processForm(Model model, @RequestParam String home, @RequestParam String destination) {
        model.addAttribute("title", "Driving During the Pandemic");
        model.addAttribute("home", home);
        model.addAttribute("destination", destination);

        for (int i = 0; i < Json.getResponseContent().length(); i++) {
            JSONObject eachData = Json.getResponseContent().getJSONObject(i);
            String state = eachData.getString("state");
            int positiveIncrease = eachData.getInt("positiveIncrease");
            int positive = eachData.getInt("positive");
            int date = eachData.getInt("date");

            if (home.equals(state)) {
                model.addAttribute("positiveIncrease", positiveIncrease);
                model.addAttribute("positive", positive);
                model.addAttribute("date", date);
            }

            if (destination.equals(state)) {
                model.addAttribute("positiveIncrease2", positiveIncrease);
                model.addAttribute("positive2", positive);
                model.addAttribute("date2", date);
            }
        }

        return "index";
    }

}
