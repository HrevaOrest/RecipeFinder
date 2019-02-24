package com.project.project.ui.choose_products;

import com.project.project.R;

import java.util.ArrayList;
import java.util.List;

class ChooseProductsPresenter {

    private List<GroupItem> groups = new ArrayList<>();

    //списки продуктів до груп
    private List<String> list1 = new ArrayList<>();
    private List<String> list2 = new ArrayList<>();


    ChooseProductsPresenter() {
        groups.add(new GroupItem("Chicken", R.drawable.kuratina));
        groups.add(new GroupItem("Beef", R.drawable.yalovichina));


        //тут додавати інформацію до списків
        list1.add("курка1");
        list1.add("курка2");

        list2.add("свинина1");
        list2.add("свиннина2");
    }

    List<GroupItem> getGroups() {
        return groups;
    }

    List<String> getList1() {
        return list1;
    }

    List<String> getList2() {
        return list2;
    }
}
