/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Admin
 */
public class SkillManagement {
    private int ID;
    private String StaffName;
    private String StaffSkill;
    private String Comment;
    private String LastDateComment;

    SkillManagement() {
     
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getStaffName() {
        return StaffName;
    }

    public void setStaffName(String StaffName) {
        this.StaffName = StaffName;
    }

    public String getStaffSkill() {
        return StaffSkill;
    }

    public void setStaffSkill(String StaffSkill) {
        this.StaffSkill = StaffSkill;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String Comment) {
        this.Comment = Comment;
    }

    public String getLastDateComment() {
        return LastDateComment;
    }

    public void setLastDateComment(String LastDateComment) {
        this.LastDateComment = LastDateComment;
    }

    public SkillManagement(int ID, String StaffName, String StaffSkill, String Comment, String LastDateComment) {
        this.ID = ID;
        this.StaffName = StaffName;
        this.StaffSkill = StaffSkill;
        this.Comment = Comment;
        this.LastDateComment = LastDateComment;
    }
}
