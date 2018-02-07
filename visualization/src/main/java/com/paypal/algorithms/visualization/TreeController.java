package com.paypal.algorithms.visualization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.paypal.algorithms.BinaryTree;

@Controller
@SpringBootApplication
public class TreeController {

    private BinaryTree<Integer> tree = new BinaryTree<Integer>();

    @RequestMapping(params = "/tree/add", method = RequestMethod.POST)
    @ResponseBody
    public BinaryTree<Integer> addValue(@RequestBody Integer value) {
        tree.addValue(value);
        return tree;
    }

    public static void main(String[] args) {
        SpringApplication.run(TreeController.class, args);
    }
}
