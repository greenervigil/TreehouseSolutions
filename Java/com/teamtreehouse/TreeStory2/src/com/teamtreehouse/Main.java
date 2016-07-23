package com.teamtreehouse;

import java.io.*;

public class Main {

    public static void main(String[] args){
        // write your code here
        try {
            Prompter prompt = new Prompter();
            Template tmpl = new Template(prompt.promptForStory());
            prompt.run(tmpl);
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}

