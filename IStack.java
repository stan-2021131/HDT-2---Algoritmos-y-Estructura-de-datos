public interface IStack<T>{
    void push(T value);
    T pop();
    T operation(char operator, T value1, T value2);
}