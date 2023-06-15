//Выполнил студент группы 2А Иванов Данил

public class Queue<T> {
    private Node<T> front;  // Указатель на передний элемент очереди
    private Node<T> rear;   // Указатель на задний элемент очереди
    
    // Внутренний класс, представляющий узел очереди
    private static class Node<T> {
        T data;          // Данные узла
        Node<T> next;    // Ссылка на следующий узел

        public Node(T data) {
            this.data = data;
        }
    }
    
    // Конструктор, инициализирующий пустую очередь
    public Queue() {
        front = null;
        rear = null;
    }
    
    // Метод для проверки, является ли очередь пустой
    public boolean isEmpty() {
        return front == null;
    }
    
    // Метод для добавления элемента в конец очереди
    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data);

        if (isEmpty()) {
            // Если очередь пустая, новый узел становится как передним, так и задним элементом
            front = newNode;
            rear = newNode;
        } else {
            // Иначе, новый узел добавляется в конец очереди
            rear.next = newNode;
            rear = newNode;
        }
    }
    
    // Метод для удаления элемента из начала очереди
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Очередь пуста!");
        }

        T data = front.data;
        front = front.next;

        // Если после удаления элемента очередь становится пустой, обновляем указатель на задний элемент
        if (front == null) {
            rear = null;
        }

        return data;
    }
    
    // Метод для получения элемента из начала очереди без его удаления
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Очередь пуста!");
        }

        return front.data;
    }
}

//Вот пример использования класса Queue:

public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();

        queue.enqueue(10);    // Добавление элемента 10 в конец очереди
        queue.enqueue(20);    // Добавление элемента 20 в конец очереди
        queue.enqueue(30);    // Добавление элемента 30 в конец очереди

        System.out.println(queue.dequeue());    // Вывод и удаление элемента из начала очереди (10)
        System.out.println(queue.peek());       // Вывод элемента из начала очереди без его удаления (20)
        System.out.println(queue.dequeue());    // Вывод и удаление элемента из начала очереди (20)

        System.out.println(queue.isEmpty());    // Проверка, является ли очередь пустой (false)
    }
}
