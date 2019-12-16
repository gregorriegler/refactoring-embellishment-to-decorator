import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class InMemoryBookRepositoryTest {

    private final InMemoryBookRepository repository = new InMemoryBookRepository();

    @Test void
    should_find_book_by_author() {
        var refactoringToPatterns = new Book("Refactoring to Patterns", "Joshua");
        repository.add("abcd", refactoringToPatterns);
        var result = repository.byAuthor("Joshua");
        assertThat(result).containsExactly(refactoringToPatterns);
    }

    @Test void
    should_utilize_author_cache() {
        var refactoringToPatterns = new Book("Refactoring to Patterns", "Joshua");
        repository.add("abcd", refactoringToPatterns);
        var intermediateResult = repository.byAuthor("Joshua");
        var result = repository.byAuthor("Joshua");
        assertThat(result).containsExactly(refactoringToPatterns);
    }
}