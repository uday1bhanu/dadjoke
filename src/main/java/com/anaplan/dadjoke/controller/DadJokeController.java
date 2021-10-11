package com.uday.dadjoke.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class DadJokeController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private static List<String> dadJokes;
    private static Map<String, String> env;

    static {
        dadJokes = new ArrayList<String>() {{
            add("MY WIFE ASKED ME FOR LIPSTICK.  I THOUGHT SHE SAID GLUE STICK.");
            add("I LIKE TELLING DAD JOKES BUT DON'T HAVE ANY KIDS.");
            add("MY WIFE TOLD ME TO STOP ACTING LIKE A FLAMINGO. I HAD TO PUT MY FOOT DOWN.");
            add("I WAS AT A REALLY EMOTIONAL WEDDING YESTERDAY... EVEN THE CAKE WAS IN TIERS");
            add("DID YOU HEAR ABOUT THE THIEF WHO STOLE A BUNCH OF CALENDARS? HE GOT 12 MONTHS");
            add("CRUSHING POP CANS IS SODA PRESSING.");
            add("I'M READING A BOOK ABOUT ANTI-GRAVITY. IT'S IMPOSSIBLE TO PUT DOWN!");
            add("MY LOCAL GRAVEYARD HIRES QUITE A FEW BOUNCERS. PEOPLE ARE JUST DYING TO GET IN");
            add("WHY DID THE CHICKEN BLUSH, BECAUSE IT SAW THE CAESAR DRESSING");
            add("LET ME GUESS… THE CURTAINS WERE DRAWN BUT THE FURNITURE WAS REAL");
            add("A MAN WALKED INTO HIS HOUSE AND WAS DELIGHTED WHEN HE DISCOVERED THAT SOMEONE HAD STOLEN ALL OF HIS LAMPS.");
            add("I ONCE SWALLOWED A DICTIONARY. IT GAVE ME THESAURUS THROAT EVER!");
            add("I'M SURE EVERYONE HERE HAS HEARD THE JOKE ABOUT THE THREE HOLES IN THE GROUND FILLED WITH WATER... YOU HAVEN'T? WELL, WELL, WELL...");
            add("I HEAR THAT DOGS CAN'T OPERATE MRI MACHINES... BUT CATSCAN");
            add("STATIONARY SHOP MOVES!");
            add("I SAW A LARGE GROUP OF COWS SITTING AROUND TOGETHER. THEY WERE HAVING A COWFERENCE");
            add("WHAT’S THE SCARIEST DATATYPE? THE BOO-LEAN");
            add("APPARENTLY YOU CAN'T USE 'BEEFSTEW' AS A PASSWORD. IT ISN'T STROGANOFF");
            add("A PHOTON CHECKS INTO A HOTEL AND IS ASKED IF HE NEEDS HELP WITH HIS LUGGAGE. HE REPLIES, NO, I'M TRAVELLING LIGHT.");
            add("A NEUTRON WALKS INTO A BAR AND ORDERS A DRINK. THE BARMAN SAYS --> FOR YOU, NO CHARGE!");
            add("TWO ATOMS WALK INTO A PUB.  ONE TURNS TO THE OTHER AND SAYS, 'I THINK I'VE LOST AN ELECTRON!.'  THE FIRST ONE SAYS, 'ARE YOU SURE?'.  THE OTHER ONE SAYS..... I'M POSITIVE.");
        }};
        env = System.getenv();
    }
    /**
     * Get dadjoke
     *
     * @return return random dadjoke
     */
    @RequestMapping(value = "/dadjoke", method = RequestMethod.GET)
    public String dadjoke(){
        String dataCenter = env.get("DC_NAME");
        String cluster = env.get("CLUSTER_NAME");
        String verion = env.get("VERSION");
        String dadJoke = dataCenter + "-" + cluster + "-"+verion + "-"+dadJokes.get((int)(Math.random()*(dadJokes.size())));
        logger.info(dadJoke);
        return dadJoke;
    }
}
