package com.driver;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public class Gmail extends Email {

    int inboxCapacity; //maximum number of mails inbox can store
    //Inbox: Stores mails. Each mail has date (Date), sender (String), message (String). It is guaranteed that message is distinct for all mails.
    //Trash: Stores mails. Each mail has date (Date), sender (String), message (String)
    private List<Mail> inbox ;
    private List<Mail> trash ;

    public Gmail(String emailId, int inboxCapacity) {
        super(emailId);
        this.inboxCapacity = inboxCapacity;
         inbox = new ArrayList<>();
         trash = new ArrayList<>();
    }

    public void receiveMail(Date date, String sender, String message) {
        // If the inbox is full, move the oldest mail in the inbox to trash and add the new mail to inbox.
        // It is guaranteed that:
        // 1. Each mail in the inbox is distinct.
        // 2. The mails are received in non-decreasing order. This means that the date of a new mail is greater than equal to the dates of mails received already.
        Mail mail = new Mail(message, date, sender);
        inbox.sort((m1, m2) -> m1.getDate().compareTo(m2.getDate()));
        if (inbox.size() >= inboxCapacity) {
            trash.add(inbox.remove(0));
        }
        inbox.add(mail);
    }

    public void deleteMail(String message) {
        // Each message is distinct
        // If the given message is found in any mail in the inbox, move the mail to trash, else do nothing
        for(int i=0;i<inbox.size();i++){
            if(StringUtils.equalsIgnoreCase(inbox.get(i).getMessage(),message)){
                trash.add(inbox.get(i));
                inbox.remove(i);
                break;
            }
        }
    }

    public String findLatestMessage() {
        // If the inbox is empty, return null
        // Else, return the message of the latest mail present in the inbox
        return inbox.isEmpty() ? null : inbox.get(inbox.size() - 1).getMessage();
    }

    public String findOldestMessage() {
        // If the inbox is empty, return null
        // Else, return the message of the oldest mail present in the inbox
        return inbox.isEmpty() ? null : inbox.get(0).getMessage();
    }

    public int findMailsBetweenDates(Date start, Date end) {
        //find number of mails in the inbox which are received between given dates
        //It is guaranteed that start date <= end date
        int count = 0;
        for (Mail mail : inbox) {
            if (mail.getDate().compareTo(start) >= 0 && mail.getDate().compareTo(end) <= 0) {
                count++;
            }
        }
        return count;
    }

    public int getInboxSize() {
        // Return number of mails in inbox
        return inbox.size();
    }

    public int getTrashSize() {
        return trash.size();
        // Return number of mails in Trash
    }

    public void emptyTrash() {
        trash.clear();
        // clear all mails in the trash
    }

    public int getInboxCapacity() {
        return this.inboxCapacity;
        // Return the maximum number of mails that can be stored in the inbox
    }
}
