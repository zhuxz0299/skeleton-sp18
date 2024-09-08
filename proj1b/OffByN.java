public class OffByN implements CharacterComparator {
    int N;

    public OffByN(int n) {
        super();
        N = n;
    }

    @Override
    public boolean equalChars(char x, char y) {
        return (x - y == N || y - x == N);
    }
}
