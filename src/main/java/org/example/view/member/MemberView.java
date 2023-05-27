package org.example.view.member;

import org.example.service.input.InputService;

public class MemberView {

    private final InputService inputService;

    public MemberView(InputService inputService) {
        this.inputService = inputService;
    }

    public void showMemberManegmentMenu() {

        while (true) {
            memberMenu();


        }
    }

    private void memberMenu() {
        System.out.println("Member Manegment :");
        System.out.println("========================");
        System.out.println("1 - Read member by id :");
        System.out.println("2 - Read all member.");
        System.out.println("3 - Add new member :");
        System.out.println();
    }


}
