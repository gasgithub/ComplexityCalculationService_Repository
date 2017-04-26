<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

  <xsl:output encoding="UTF-8" method="xml"></xsl:output>

  <xsl:template match="node() | @*">
    <xsl:copy>
      <xsl:apply-templates select="node() | @*"/>
    </xsl:copy>
  </xsl:template>

  <xsl:template match="/">
    <testsuite>
      <xsl:attribute name="name">
        <xsl:value-of select="'checkstyle.TestApplication'" />
      </xsl:attribute>
      <xsl:attribute name="tests">
       <xsl:value-of select="count(.//error)" />
      </xsl:attribute>
      <xsl:attribute name="failures">
        <xsl:value-of select="count(.//error)" />
      </xsl:attribute>
      <xsl:attribute name="errors">
       <xsl:value-of select="0" />
      </xsl:attribute>
      <xsl:attribute name="skipped">
        <xsl:value-of select="0" />
      </xsl:attribute>
      <xsl:for-each select="//checkstyle">
        <xsl:apply-templates />
      </xsl:for-each>
    </testsuite>
  </xsl:template>

  <xsl:template match="file">
    <xsl:for-each select=".//error">
      <testcase>
        <xsl:attribute name="classname">
          <xsl:value-of select="../@name" />
        </xsl:attribute>
        <xsl:attribute name="name">
          <xsl:value-of select="../@name" />
        </xsl:attribute>
        <failure>
          <xsl:attribute name="type">
            <xsl:value-of select="@source" />
          </xsl:attribute>
          <xsl:text>Line </xsl:text>
          <xsl:value-of select="@line" />
          <xsl:text>: </xsl:text>
          <xsl:value-of select="@message" />
        </failure>
      </testcase>
    </xsl:for-each>
  </xsl:template>

</xsl:stylesheet>
