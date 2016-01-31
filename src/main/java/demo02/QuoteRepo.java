package demo02;

import org.apache.commons.lang3.RandomUtils;
import org.springframework.stereotype.Component;

@Component
class QuoteRepo {

    private static final String[] QUOTES = {
        "When 900 years old, you reach… Look as good, you will not.",
        "Judge me by my size, do you?",
        "Do. Or do not. There is no try.",
        "Mmm. Lost a planet, Master Obi-Wan has. How embarrassing.",
        "Death is a natural part of life. Rejoice for those around you who transform into the Force.",
        "Fear is the path to the dark side…fear leads to anger…anger leads to hate…hate leads to suffering.",
        "Great, kid. Don’t get cocky",
        "You can’t win, Darth. Strike me down, and I will become more powerful than you could possibly imagine.",
        "Traveling through hyperspace ain't like dusting crops, farm boy.",
        "Don't call me a mindless philosopher, you overweight glob of grease.",
        "Hello. I don't believe we have been introduced. R2-D2? A pleasure to meet you. I am C-3PO, Human-Cyborg Relations.",
        "Don't get technical with me. What mission? What are you talking about? I've just about had enough of you. Go that way, you'll be malfunctioning in a day you near-sighted scrap pile.",
        "Obi-Wan Kenobi. Obi-Wan. Now that's a name I have not heard in a long time. A long time.",
        "Oh my. Space travel sound rather perilous. I can assure you they will never get me on one of those dreadful Star Ships.",
        "Remember...the Force will be with you, always."
    };

    String chooseOne() {
        return QUOTES[RandomUtils.nextInt(0, QUOTES.length)];
    }
}
