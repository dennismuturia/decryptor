package com.company;

class SourceLicense {
    static boolean getSource(String License){
        String[]x = License.split(" ");
        return x[0].equals("28-CF-DA-E1-B7-7C");
    }
}
