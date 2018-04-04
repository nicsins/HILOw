package HighLow;

import HighLow.Deck;
import HighLow.Hand;
import org.omg.PortableInterceptor.LOCATION_FORWARD;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Random;

public class HiLowGUI extends JFrame{
    private JRadioButton HighRadioButton;
    private JRadioButton InBetwenRadioButton;
    private JRadioButton lowRadioButton;
    private JLabel Result;
    private JLabel HighCard;
    private JLabel LowCard;
    private JButton newCardButton;
    private JPanel Main_Panel;
    private JButton checkAnswerButton;
    private JLabel YesNo;

    private Deck deck=new Deck();
    private Card highCard;
    private Card lowCard;
    private Card secretCard;
    private final  String CORRECT="Correct";
    private final  String INCORRECT="Incorrect";


    public HiLowGUI() {
        setContentPane(Main_Panel);
        pack();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        newCardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deck.refill();
                highCard=deck.drawCard();
                lowCard=deck.drawCard();
                secretCard=deck.drawCard();

                if (lowCard.value>=highCard.value){
                    lowCard=deck.drawCard();
                }
                if (secretCard.value==highCard.value||secretCard.value==lowCard.value){
                    secretCard=deck.drawCard();
                }

                HighCard.setText(highCard.toString());
                LowCard.setText(lowCard.toString());


            }
        });



        checkAnswerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JRadioButton HighRadioButton=new JRadioButton();
                JRadioButton lowRadioButton=new JRadioButton();
                JRadioButton InBetwenRadioButton=new JRadioButton();


                if ((secretCard.value>highCard.value) && (HighRadioButton.isSelected())){
                    Result.setText(CORRECT);
                }
                else if((secretCard.value<lowCard.value)&&(lowRadioButton.isSelected())){
                    YesNo.setText(CORRECT);
                    Result.setText("Good Job!!");
                }

                if((secretCard.value> lowCard.value && secretCard.value<highCard.value)&&(InBetwenRadioButton.isSelected())){
                    YesNo.setText(CORRECT);
                    Result.setText("Good Job!!");
                }
                else{
                    YesNo.setText(INCORRECT);
                    Result.setText("the correct card is "+secretCard.toString());}

            }
        });
    }


}


