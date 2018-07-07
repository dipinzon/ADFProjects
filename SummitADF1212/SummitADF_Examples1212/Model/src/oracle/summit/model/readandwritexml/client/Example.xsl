<?xml version="1.0" encoding="windows-1252" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:template match="/">
    <CustomerNames>
      <xsl:for-each select="/CustomersView/CustomersViewRow">
        <xsl:sort select="Name"/>
        <Customer Contact="{Name}"/>
      </xsl:for-each>
    </CustomerNames>
  </xsl:template>
</xsl:stylesheet>