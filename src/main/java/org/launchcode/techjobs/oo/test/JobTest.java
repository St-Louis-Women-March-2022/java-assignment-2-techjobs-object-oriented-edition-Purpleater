package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();

        org.junit.Assert.assertNotEquals(job1, job2);
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        org.junit.Assert.assertTrue(job.getName() instanceof String);
        org.junit.Assert.assertTrue(job.getEmployer() instanceof Employer);
        org.junit.Assert.assertTrue(job.getLocation() instanceof Location);
        org.junit.Assert.assertTrue(job.getPositionType() instanceof PositionType);
        org.junit.Assert.assertTrue(job.getCoreCompetency() instanceof CoreCompetency);


        org.junit.Assert.assertEquals(job.getName(), "Product tester");
        org.junit.Assert.assertEquals(job.getEmployer().getValue(), "ACME");
        org.junit.Assert.assertEquals(job.getLocation().getValue(), "Desert");
        org.junit.Assert.assertEquals(job.getPositionType().getValue(), "Quality control");
        org.junit.Assert.assertEquals(job.getCoreCompetency().getValue(), "Persistence");

    }

    @Test
    public void testJobsForEquality(){
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        org.junit.Assert.assertFalse(job1.getId() == job2.getId());
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String toString = job.toString(job.getId(), job.getName(), job.getEmployer(), job.getLocation(), job.getPositionType(), job.getCoreCompetency());

        char firstChar = toString.charAt(0);
        char lastChar = toString.charAt(toString.length()-1);

        org.junit.Assert.assertEquals(firstChar, '\n');
        org.junit.Assert.assertEquals(lastChar, '\n');

    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String toString = job.toString(job.getId(), job.getName(), job.getEmployer(), job.getLocation(), job.getPositionType(), job.getCoreCompetency());

        org.junit.Assert.assertEquals(toString, "\n" +
                "\nID: " + job.getId() +
                "\nName: " + job.getName() +
                "\nEmployer: " + job.getEmployer() +
                "\nLocation: " + job.getLocation() +
                "\nPosition Type: " + job.getPositionType() +
                "\nCore Competency: " + job.getCoreCompetency() +
                "\n" );

    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job job = new Job("Product tester", new Employer(""), new Location("Desert"), new PositionType(""), new CoreCompetency("Persistence"));
        String toString = job.toString(job.getId(), job.getName(), job.getEmployer(), job.getLocation(), job.getPositionType(), job.getCoreCompetency());

        org.junit.Assert.assertEquals(toString, "\n" +
                "\nID: " + job.getId() +
                "\nName: " + job.getName() +
                "\nEmployer: " + job.getEmployer() +
                "\nLocation: " + job.getLocation() +
                "\nPosition Type: " + job.getPositionType() +
                "\nCore Competency: " + job.getCoreCompetency() +
                "\n");
    }
    }

