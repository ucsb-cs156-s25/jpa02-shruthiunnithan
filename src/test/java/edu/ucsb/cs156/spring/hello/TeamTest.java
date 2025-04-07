package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    //equals testing
    @Test
    public void equals_case1() {
        Team t = new Team();
        assert(t.equals(t));
    }

    @Test
    public void equals_case2() {
        Team t = new Team();
        Object o = new Object();
        assert(!t.equals(o));
    }

    @Test
    public void equals_case3_1() {
        ArrayList<String> m = new ArrayList<String>();
        m.add("fee");
        m.add("foo");
        m.add("fum");
        Team t1 = new Team("a");
        t1.setMembers(m);
        Team t2 = new Team("a");
        t2.setMembers(m);
        assert(t1.equals(t2));
    }

    @Test
    public void equals_case3_2() {
        ArrayList<String> m = new ArrayList<String>();
        m.add("fee");
        m.add("foo");
        m.add("fum");
        Team t1 = new Team("a");
        t1.setMembers(m);
        Team t2 = new Team("b");
        t2.setMembers(m);
        assert(!t1.equals(t2));
    }

    @Test
    public void equals_case3_3() {
        ArrayList<String> m = new ArrayList<String>();
        m.add("fee");
        m.add("foo");
        m.add("fum");
        Team t1 = new Team("a");
        t1.setMembers(m);
        ArrayList<String> n = new ArrayList<String>();
        n.add("bob");
        n.add("billy");
        n.add("joe");
        Team t2 = new Team("a");
        t2.setMembers(n);
        assert(!t1.equals(t2));
    }

    @Test
    public void equals_case3_4() {
        ArrayList<String> m = new ArrayList<String>();
        m.add("fee");
        m.add("foo");
        m.add("fum");
        Team t1 = new Team("a");
        t1.setMembers(m);
        m.set(0, "bob");
        Team t2 = new Team("b");
        t2.setMembers(m);
        assert(!t1.equals(t2));
    }

    @Test
    public void hashCode_returns_correct() {
        Team t = new Team();
        int result = t.hashCode();
        int expectedResult = 1;
        assertEquals(expectedResult, result);
    }
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

}
