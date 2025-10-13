/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
    Comprehensive Version (12th ed.). Pearson Education, Inc.
    Modified by R. Krasso 2021
    Additional modifications by A. Rodriguez 2025
*/

package Module_6.ComposerApp;

public interface ComposerDao extends GenericDao<Composer, Integer> {
    // Interface used intended to have its methods overridden with behaviors specific to other Daos, including MemComposerDao.
} 
