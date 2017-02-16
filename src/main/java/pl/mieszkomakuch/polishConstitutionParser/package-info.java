/**
 * Package contains set of classes to parse the Constitution of Poland from a text file into a objective form.
 * It enables to display:
 * <ul>
 * <li>
 * The content of the article with the specified number
 * </li>
 * <li>
 * The content of the section with the specified number (content of the section contains: section number,
 * section title and content of all articles included in this section)
 * </li>
 * <li>
 * Range of articles
 * </li>
 * <li>
 * Range of sections
 * </li>
 * </ul>
 * While parsing ConstitutionSystem deletes any unnecessary elements such as:
 * <ul>
 * <li>
 * hyphens "-" by joining broken words at line breaks
 * </li>
 * <li>
 * duplicated lines "Kancelaria Sejmu" and date
 * </li>
 * </ul>
 * It also retains the structure of the original file e.g. ordered list from article 10 will not
 * be displayed in a single line.
 */
package pl.mieszkomakuch.polishConstitutionParser;