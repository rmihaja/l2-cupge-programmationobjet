// Version 14/05/2020
package files;

public interface IFileBornee extends IFileNonBornee {
	/**
	 * indique si la file est pleine
	 *
	 * @return true si pleine, false sinon
	 */
	public boolean isFull();

	/**
	 * retourne la capacité de la file, sa taille max
	 *
	 * @return taille max de la file
	 */
	public int capacity();
}