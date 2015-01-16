package nl.basjes.test;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;

import java.util.TimeZone;

public class TimeStampParseTest {

  @Test
  public void testParse(){
    DateTimeFormatter formatter = DateTimeFormat.forPattern("[dd/MMM/yyyy:HH:mm:ss ZZ]");;
    DateTime dateTime = formatter.parseDateTime("[31/Dec/2012:23:00:44 -0700]");

    System.out.println("Default Zone = " + TimeZone.getDefault());
    System.out.println("Zone = " + dateTime.getZone());
    System.out.println("Hour = " + dateTime.hourOfDay().getAsString());
  }

  @Test
  public void testTimeStamp_UTC() throws Exception {
    TimeZone defaultTZ = TimeZone.getDefault();
    try {
      // Set default time zone to Amsterdam
      TimeZone.setDefault(TimeZone.getTimeZone("UTC"));

      // Run the actual test.
      testParse();
    }
    finally{
      TimeZone.setDefault(defaultTZ);
    }
  }

  @Test
  public void testTimeStamp_Amsterdam() throws Exception {
    TimeZone defaultTZ = TimeZone.getDefault();
    try {
      // Set default time zone to Amsterdam
      TimeZone.setDefault(TimeZone.getTimeZone("Europe/Amsterdam"));

      // Run the actual test.
      testParse();
    }
    finally{
      TimeZone.setDefault(defaultTZ);
    }
  }

  @Test
  public void testTimeStamp_Los_Angeles() throws Exception {
    TimeZone defaultTZ = TimeZone.getDefault();
    try {
      System.out.println(TimeZone.getDefault());
      // Set default time zone to Amsterdam
      TimeZone.setDefault(TimeZone.getTimeZone("America/Los_Angeles"));
      System.out.println(TimeZone.getDefault());

      // Run the actual test.
      testParse();
    }
    finally{
      TimeZone.setDefault(defaultTZ);
    }
  }

}