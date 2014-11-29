package com.blakeanneberg.confidentdyslexicapp;

import java.util.Random;

/**
 * Created by blakeanneberg on 11/18/14.
 */
public class FactBook {


    //member variable properties of the object
    public String[] mFacts = {
            "Success happens because of your Dyslexia, not despite it.",
            "The accommodation needs for people with physical disabilities are the same as for people with Learning Disabilities like Dyslexia.",
            "Find other people with Dyslexia, share experiences, learn from them and this will help you feeling good.",
            "In owning your LD or ADHD identities, the more empowered you and the wider LD/ADHD community will become.",
            "When you accept your LD or ADHD, everyone around you will see your ease and comfort.",
            "Find something that will boost your self-esteem. This will in turn help you become more resilient and will help you learn how you learn.",
            "Learning disabilities are not curable, but people do get better.",
            "Learning Disabilities and ADHD have nothing to do with native intelligence. LD and ADHD people are often above average intelligence.",
            "Learning Disabilities are a wide neurological term. They involve the brain's ability to receive, process, store, express, and respond to information",
            "Develop a healthy identity as a learner. Seek out healthy learning environments. Both of are important for LD/ADHD.",
            "Focus on strengths and talents in early childhood education. This will increase resilience when facing obstacles in basic academic skills.",
            "Self-esteem increases with praise. This will enable areas of self-esteem in of social, physical, skills and character.",
            "ADHD and Learning Disabilities like Dyslexia are never shameful. We all have strengths and weaknesses depending on the kind of learning environment.",
            "Kindness, curiosity and perseverance are important in life.",
            "Don't wait till you fail to ask for help. Allies, advocates and mentors will want to inspire you with help.",
            "Learning how to succeed in your education, depends on knowing which method of learning suits the task.",
            "You have permission to dream big. Many LD/ADHDers thrive when they take risks.",
            "Many LD/ADHDers are great creative problem solvers. This involves self-knowledge and awareness.",
            "To be a good self-advocate, you need to accept your limitations and own your strengths.",









    };

    public String getFact() {


        String fact = "";
        Random randomGenerator = new Random(); //construct a new random number generator
        int randomNumber = randomGenerator.nextInt(mFacts.length);

        fact = mFacts[randomNumber];
        return fact;
    }
}