/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
    Comprehensive Version (12th ed.). Pearson Education, Inc.
    Modified by R. Krasso 2021
    Additional modifications by A. Rodriguez 2025
*/

package Module_6.ComposerApp;

import java.util.List;

public interface GenericDao<E, K> 
{
    // Interface used intended to have its methods overridden with behaviors specific to other Daos, including ComposerDao and MemComposerDao.
    List<E> findAll();
    E findBy(K key);
    void insert(E entity);
}
