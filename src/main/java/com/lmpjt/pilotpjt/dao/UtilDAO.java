package com.lmpjt.pilotpjt.dao;

import java.util.HashMap;

public interface UtilDAO {
    public int getTotalBooks();
    public int getTotalUsers();
    public int getBorrowedBooks();
    public int getOverdueBooks();
    public int getUserBorrowed(HashMap<String, String> param);
}
