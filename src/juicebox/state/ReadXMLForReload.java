/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2011-2015 Broad Institute, Aiden Lab
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *  THE SOFTWARE.
 */

package juicebox.state;

/**
 * Created by Zulkifl on 7/20/2015.
 */

import juicebox.HiC;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class ReadXMLForReload {

    private final HiC hic;

    private String mapPath = null;
    private String Map = null;
    private String MapURL = null;
    private String XChromosome = null;
    private String YChromosome = null;
    private String UnitName = null;
    private String BinSize = null;
    private String xOrigin = null;
    private String yOrigin = null;
    private String ScaleFactor = null;
    private String DisplayOption = null;
    private String NormalizationType = null;
    private String MinColorVal = null;
    private String LowerColorVal = null;
    private String UpperColorVal = null;
    private String MaxColorVal = null;
    private String LoadedTrackURLS = null;
    private String LoadedTrackNames = null;
    private String[] infoForReload;

    public ReadXMLForReload(HiC hic){this.hic = hic;}


    public boolean readXML(String xml, String mapSelection) {
        infoForReload = new String[18];
        Document dom;
        // Make an  instance of the DocumentBuilderFactory
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            // use the factory to take an instance of the document builder
            DocumentBuilder db = dbf.newDocumentBuilder();
            // parse using the builder to get the DOM mapping of the
            // XML file
            dom = db.parse(xml);

            Element element = dom.getDocumentElement();
            NodeList nodeList = dom.getElementsByTagName("STATE");
            for (int i = 0; i < nodeList.getLength(); i++) {
                if (nodeList.item(i).getAttributes().getNamedItem("SelectedPath").toString().contains(mapSelection)) {

                    mapPath = getTextValue(mapPath, element, "MapPath");
                    if (mapPath != null) {
                        if (!mapPath.isEmpty())
                            infoForReload[0] = mapPath;
                    }

                    Map = getTextValue(Map, element, "Map");
                    if (Map != null) {
                        if (!Map.isEmpty())
                            infoForReload[1] = Map;
                    }

                    MapURL = getTextValue(MapURL, element, "MapURL");
                    if (MapURL != null) {
                        if (!MapURL.isEmpty())
                            infoForReload[2] = MapURL;
                    }

                    XChromosome = getTextValue(XChromosome, element, "XChromosome");
                    if (XChromosome != null) {
                        if (!XChromosome.isEmpty())
                            infoForReload[3] = XChromosome;
                    }

                    YChromosome = getTextValue(YChromosome, element, "YChromosome");
                    if (YChromosome != null) {
                        if (!YChromosome.isEmpty())
                            infoForReload[4] = YChromosome;
                    }

                    UnitName = getTextValue(UnitName, element, "UnitName");
                    if (UnitName != null) {
                        if (!UnitName.isEmpty())
                            infoForReload[5] = UnitName;
                    }

                    BinSize = getTextValue(BinSize, element, "BinSize");
                    if (BinSize != null) {
                        if (!BinSize.isEmpty())
                            infoForReload[6] = BinSize;
                    }

                    xOrigin = getTextValue(xOrigin, element, "xOrigin");
                    if (xOrigin != null) {
                        if (!xOrigin.isEmpty())
                            infoForReload[7] = xOrigin;
                    }

                    yOrigin = getTextValue(yOrigin, element, "yOrigin");
                    if (yOrigin != null) {
                        if (!yOrigin.isEmpty())
                            infoForReload[8] = yOrigin;
                    }

                    ScaleFactor = getTextValue(ScaleFactor, element, "ScaleFactor");
                    if (ScaleFactor != null) {
                        if (!ScaleFactor.isEmpty())
                            infoForReload[9] = ScaleFactor;
                    }

                    DisplayOption = getTextValue(DisplayOption, element, "DisplayOption");
                    if (DisplayOption != null) {
                        if (!DisplayOption.isEmpty())
                            infoForReload[10] = DisplayOption;
                    }

                    NormalizationType = getTextValue(NormalizationType, element, "NormalizationType");
                    if (NormalizationType != null) {
                        if (!NormalizationType.isEmpty())
                            infoForReload[11] = NormalizationType;
                    }

                    MinColorVal = getTextValue(MinColorVal, element, "MinColorVal");
                    if (MinColorVal != null) {
                        if (!MinColorVal.isEmpty())
                            infoForReload[12] = MinColorVal;
                    }

                    LowerColorVal = getTextValue(LowerColorVal, element, "LowerColorVal");
                    if (LowerColorVal != null) {
                        if (!LowerColorVal.isEmpty())
                            infoForReload[13] = LowerColorVal;
                    }

                    UpperColorVal = getTextValue(UpperColorVal, element, "UpperColorVal");
                    if (UpperColorVal != null) {
                        if (!UpperColorVal.isEmpty())
                            infoForReload[14] = UpperColorVal;
                    }

                    MaxColorVal = getTextValue(MaxColorVal, element, "MaxColorVal");
                    if (MaxColorVal != null) {
                        if (!MaxColorVal.isEmpty())
                            infoForReload[15] = MaxColorVal;
                    }

                    LoadedTrackURLS = getTextValue(LoadedTrackURLS, element, "LoadedTrackURLS");
                    if (LoadedTrackURLS != null) {
                        if (!LoadedTrackURLS.isEmpty())
                            infoForReload[16] = LoadedTrackURLS;
                    }

                    LoadedTrackNames = getTextValue(LoadedTrackNames, element, "LoadedTrackNames");
                    if (LoadedTrackNames != null) {
                        if (!LoadedTrackNames.isEmpty())
                            infoForReload[17] = LoadedTrackNames;
                    }
                }
            }

            hic.reloadPreviousStateFromXML(infoForReload);

            return true;

        } catch (ParserConfigurationException pce) {
            System.out.println(pce.getMessage());
        } catch (SAXException se) {
            System.out.println(se.getMessage());
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }

        return false;
    }

    private String getTextValue(String def, Element doc, String tag) {
        String value = def;
        NodeList nl;
        nl = doc.getElementsByTagName(tag);
        if (nl.getLength() > 0 && nl.item(0).hasChildNodes()) {
            value = nl.item(0).getFirstChild().getNodeValue();
        }
        return value;
    }

}

