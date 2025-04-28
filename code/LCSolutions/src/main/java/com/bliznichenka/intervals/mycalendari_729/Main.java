package com.bliznichenka.intervals.mycalendari_729;

public class Main {
    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();
        myCalendar.book(10, 20); // return True
        myCalendar.book(15, 25); // return False, It can not be booked because time 15 is already booked by another event.
        myCalendar.book(20, 30); // return True, The event can be booked, as the first event takes every time less than 20, but not including 20.
    }
}
