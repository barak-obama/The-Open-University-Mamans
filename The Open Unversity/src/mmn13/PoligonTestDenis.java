package mmn13;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PoligonTestDenis.
 *
 * @author  (Denis Bounkin)
 * @version (03.05.2015)
 */
public class PoligonTestDenis
{
    private final double EPSILON = 0.1;
    private final double PERIMETER_MAMAN_DEFAULT = 18.47754906310363;
    private final double PERIMETER_BOUNDING_BOX = 24.0;
    private final double AREA_MAMAN_DEFAULT = 22.5;
    private final double AREA_BOUNDING_BOX = 36.0;
    private Polygon _denis;
    private Polygon _denisMamanDefault;
    private Polygon _denisBoundingBox;
    private Point1 _denisPoint1;
    private Point1 _denisPoint2;
    /**
     * Default constructor for test class PoligonTestDenis
     */
    public PoligonTestDenis()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        _denis = new Polygon();
        _denisMamanDefault = new Polygon();
        _denisMamanDefault.addVertex(2, 1);
        _denisMamanDefault.addVertex(5, 0);
        _denisMamanDefault.addVertex(7, 5);
        _denisMamanDefault.addVertex(4, 6);
        _denisMamanDefault.addVertex(1, 4);
        _denisBoundingBox = new Polygon();
        _denisBoundingBox.addVertex(1, 0);
        _denisBoundingBox.addVertex(7, 0);
        _denisBoundingBox.addVertex(7, 6);
        _denisBoundingBox.addVertex(1, 6);
        _denisPoint1 = new Point1(4, 6);
        _denisPoint2 = new Point1(7, 6);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    @Test
    public void toStringPolygonEmpty()
    {
        assertEquals("Please check toString method for empty polygon... denis\n\n", "The polygon has 0 vertices.", _denis.toString());
    }
    
    @Test
    public void toStringPolygon()
    {
        int counter = 0;
        while(counter < 5) 
        {
            _denis.addVertex(0, 0);
            counter++;
        }
        assertEquals("Please check toString method... denis\n\n", "The polygon has 5 vertices:\n((0,0),(0,0),(0,0),(0,0),(0,0))", _denis.toString());
    }
    
    @Test
    public void PolygonMustBe10maxVertices()
    {
        int counter = 0;
        while(_denis.addVertex(0, 0)) 
        {
            counter++;
        }
        assertEquals("Must be 10 vertices maximum in the polygon... Check constructor... denis\n\n", true, 10 == counter);
    }
    
    @Test
    public void PolygonIsBigger()
    {
        _denis.addVertex(2, 1);
        _denis.addVertex(5, 0);
        _denis.addVertex(7, 5);
        _denis.addVertex(4, 6);
        _denis.addVertex(1, 4);
        assertEquals("Check isBigger method... denis\n\n", false, _denis.isBigger(_denisMamanDefault));
        assertEquals("Check isBigger method... denis\n\n", false, _denisMamanDefault.isBigger(_denis));
        assertEquals("Check isBigger method... denis\n\n", false, _denisMamanDefault.isBigger(_denisBoundingBox));
        assertEquals("Check isBigger method... denis\n\n", true, _denisBoundingBox.isBigger(_denisMamanDefault));
    }
    
    @Test
    public void addVertexIntoPolygonFull()
    {
        while(_denis.addVertex(0, 0)) 
        {
        }
        assertEquals("check addVertex method... Polygon is full... denis\n\n", false, _denis.addVertex(0, 0));
    }
    
    @Test
    public void highestVertexInPolygon()
    {
        assertEquals("Check highestVertex method... Polygon is empty.. denis\n\n", null, _denis.highestVertex());
        assertEquals("Check highestVertex method... denis\n\n", true, _denisPoint1.equals(_denisMamanDefault.highestVertex()));
        assertEquals("Check highestVertex method... denis\n\n", true, _denisPoint2.equals(_denisBoundingBox.highestVertex()));
    }
    
    @Test
    public void highestVertexInPolygonAliasing()
    {
        Polygon _denisTmp = new Polygon();
        _denisTmp.addVertex(2, 1);
        _denisTmp.addVertex(5, 0);
        _denisTmp.addVertex(7, 5);
        _denisTmp.addVertex(4, 6);
        _denisTmp.addVertex(1, 4);
        Point1 _denisPointTmp = _denisMamanDefault.highestVertex();
        _denisPointTmp.setX(9);
        assertEquals("Check Anti-aliasing in the highestVertex method... denis\n\n", _denisTmp.toString(), _denisMamanDefault.toString());
    }
    
    @Test
    public void calcPerimeterPolygon()
    {
        assertEquals("Check calcPerimeter method... 0 vertices in the polygon... denis\n\n", true, _denis.calcPerimeter() == 0.0);
        _denis.addVertex(10, 10);
        assertEquals("Check calcPerimeter method... 1 vertices in the polygon... denis\n\n", true, _denis.calcPerimeter() == 0.0);
        _denis.addVertex(13, 14);
        assertEquals("Check calcPerimeter method... 2 vertices in the polygon... denis\n\n", true, _denis.calcPerimeter() == 5.0);
        assertEquals("Check calcPerimeter method... denis\n\n", true, Math.abs(_denisMamanDefault.calcPerimeter() - PERIMETER_MAMAN_DEFAULT) < EPSILON);
        assertEquals("Check calcPerimeter method... denis\n\n", true, Math.abs(_denisBoundingBox.calcPerimeter() - PERIMETER_BOUNDING_BOX) < EPSILON);
    }
    
    @Test
    public void calcAreaPolygon()
    {
        assertEquals("Check calcArea method... 0 vertices in the polygon... denis\n\n", true, _denis.calcArea() == 0.0);
        _denis.addVertex(10, 10);
        assertEquals("Check calcArea method... 1 vertices in the polygon... denis\n\n", true, _denis.calcArea() == 0.0);
        _denis.addVertex(13, 10);
        assertEquals("Check calcArea method... 2 vertices in the polygon... denis\n\n", true, _denis.calcArea() == 0.0);
        _denis.addVertex(13, 14);
        assertEquals("Check calcArea method... 3 vertices in the polygon... denis\n\n", true, _denis.calcArea() == 6.0);
        assertEquals("Check calcArea method... denis\n\n", true, Math.abs(_denisMamanDefault.calcArea() - AREA_MAMAN_DEFAULT) < EPSILON);
        assertEquals("Check calcArea method... denis\n\n", true, Math.abs(_denisBoundingBox.calcArea() - AREA_BOUNDING_BOX) < EPSILON);
    }
    
    @Test
    public void findVertexInPolygon()
    {
        assertEquals("Check findVertex method... denis\n\n", true, _denisMamanDefault.findVertex(_denisPoint1) == 3);
        assertEquals("Check findVertex method... denis\n\n", true, _denisBoundingBox.findVertex(_denisPoint2) == 2);
        _denisPoint1.setX(9);
        _denisPoint2.setX(9);
        assertEquals("Check findVertex method... this point is not in the polygon.. denis\n\n", true, _denisMamanDefault.findVertex(_denisPoint1) == -1);
        assertEquals("Check findVertex method... this point is not in the polygon.. denis\n\n", true, _denisBoundingBox.findVertex(_denisPoint2) == -1);
    }
    
    @Test
    public void getNextVertexFromPolygon()
    {
        Point1 _denisPointTmp = new Point1(0, 0); 
        assertEquals("Check getNextVertex method... this point is not in the Empty Polygon... denis\n\n", null, _denis.getNextVertex(_denisPointTmp));
        assertEquals("Check getNextVertex method... this point is not in the Polygon... denis\n\n", null, _denisMamanDefault.getNextVertex(_denisPointTmp));
        assertEquals("Check getNextVertex method... this point is not in the Polygon... denis\n\n", null, _denisBoundingBox.getNextVertex(_denisPointTmp));
        _denis.addVertex(0, 0);
        assertEquals("Check getNextVertex method... 1 vertex in polygon only... denis\n\n", true, _denisPointTmp.equals(_denis.getNextVertex(_denisPointTmp)));
        _denisPointTmp.setX(7);
        _denisPointTmp.setY(5);
        assertEquals("Check getNextVertex method... denis\n\n", true, _denisPoint1.equals(_denisMamanDefault.getNextVertex(_denisPointTmp)));
        _denisPointTmp.setY(0);
        assertEquals("Check getNextVertex method... denis\n\n", true, _denisPoint2.equals(_denisBoundingBox.getNextVertex(_denisPointTmp)));
        _denisPointTmp.setX(2);
        _denisPointTmp.setY(1);
        _denisPoint1.setX(1);
        _denisPoint1.setY(4);
        assertEquals("Check getNextVertex method... last vertex in polygon... denis\n\n", true, _denisPointTmp.equals(_denisMamanDefault.getNextVertex(_denisPoint1)));
        _denisPointTmp.setX(1);
        _denisPointTmp.setY(0);
        _denisPoint2.setX(1);
        _denisPoint2.setY(6);
        assertEquals("Check getNextVertex method... last vertex in polygon... denis\n\n", true, _denisPointTmp.equals(_denisBoundingBox.getNextVertex(_denisPoint2)));
    }
    
    @Test
    public void getNextVertexFromPolygonAliasing()
    {
        Polygon _denisTmp0 = new Polygon();
        _denisTmp0.addVertex(4, 6);
        Polygon _denisTmp1 = new Polygon();
        _denisTmp1.addVertex(4, 6);
        Point1 _denisPointTmp0 = _denisTmp1.getNextVertex(_denisPoint1);
        _denisPointTmp0.setX(9);
        assertEquals("Check Anti-aliasing in the getNextVertex method... 1 vertex in polygon only... denis\n\n", _denisTmp0.toString(), _denisTmp1.toString());
        Polygon _denisTmp = new Polygon();
        _denisTmp.addVertex(2, 1);
        _denisTmp.addVertex(5, 0);
        _denisTmp.addVertex(7, 5);
        _denisTmp.addVertex(4, 6);
        _denisTmp.addVertex(1, 4);
        Point1 _denisPointTmp = _denisMamanDefault.getNextVertex(_denisPoint1);
        _denisPointTmp.setX(9);
        assertEquals("Check Anti-aliasing in the getNextVertex method... denis\n\n", _denisTmp.toString(), _denisMamanDefault.toString());
        _denisPoint1.setX(1);
        _denisPoint1.setY(4);
        Point1 _denisPointTmp9 = _denisMamanDefault.getNextVertex(_denisPoint1);
        _denisPointTmp9.setX(9);
        assertEquals("Check Anti-aliasing in the getNextVertex method... last vertex in polygon... denis\n\n", _denisTmp.toString(), _denisMamanDefault.toString());
    }
    
    @Test
    public void getBoundingBoxMethod()
    {
    	System.out.println(_denisBoundingBox.toString());
    	System.out.println(_denisMamanDefault.getBoundingBox().toString());
        assertEquals("Check getBoundingBox method... denis\n\n", _denisBoundingBox.toString(), _denisMamanDefault.getBoundingBox().toString());
    }
}
