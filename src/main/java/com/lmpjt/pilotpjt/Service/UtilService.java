package com.lmpjt.pilotpjt.Service;

import java.util.HashMap;

public interface UtilService {
    public int getTotalBooks();
    public int getTotalUsers();
    public int getBorrowedBooks();
    public int getOverdueBooks();
    public int getUserBorrowed(HashMap<String, String> param);
}
