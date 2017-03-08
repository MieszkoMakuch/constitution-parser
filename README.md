## Parser of the Constitution of Poland

Package contains set of classes to parse the Constitution of Poland from a text file into a objective form.

It enables to display:
- The content of the article with the specified number
- The content of the section with the specified number (content of the section contains: section number, section title and content of all articles included in this section)
- Range of articles
- Range of sections

While parsing ConstitutionSystem deletes any unnecessary elements such as:
- hyphens "-" by joining broken words at line breaks
- duplicated lines "Kancelaria Sejmu" and date

It also retains the structure of the original file e.g. ordered list from article 10 will not be displayed in a single line.

**Note that** because this is a parser of the Constitution of Poland some prompts may be written in Polish.
