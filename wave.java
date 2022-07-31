// Реализация волнового алгоритма: матрица NxN, свободные клетки обозначены 0, препятствия обозначены -1. Точки старта и финиша xStart, yStart, xEnd, yEnd
//Выводит количество шагов в кратчайшем маршруте. Можно распечатать матрицу-результат.

public class wave {


    public static int Steps_Count(int [][] field, int xStart, int yStart, int xEnd, int yEnd)
    {
        int N = field.length;
        int i = 1;
        field[xStart][yStart] = 1;

        while (field[xEnd][yEnd] == 0 && i < Math.pow(N, 2))
        {
            i ++; 

            for (int x = 0; x < N; x ++)
            {
                for(int y = 0; y < N; y ++)
                {
                    if (x + 1 < N && field[x][y] == i - 1 && field[x + 1][y] == 0)
                    {
                        field[x + 1][y] = i;
                    }

                    if (0 <= x - 1 && field[x][y] == i - 1 && field[x - 1][y] == 0)
                    {
                        field[x - 1][y] = i;
                    }

                    if (y + 1 < N && field[x][y] == i - 1 && field[x][y + 1] == 0)
                    {
                        field[x][y + 1] = i;
                    }

                    if (0 <= y - 1 && field[x][y] == i - 1 && field[x][y - 1] == 0)
                    {
                        field[x][y - 1] = i;
                    }
                }
            }
        }          

        return field[xEnd][yEnd];
    }

    public static void Print_Array(int [][] array)
    {
        int M = array.length;
        int N = array[0].length;
        for (int x = 0; x < M; x ++)
        {
            for(int y = 0; y < N; y ++)
            {
                System.out.print(Integer.toString(array[x][y]) + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }


    public static int [][] path(int [][] field, int xEnd, int yEnd, int res)
    {
        int [][] xyPath = new int [res][2]; 
        
        xyPath[res - 1][0] = xEnd;
        xyPath[res - 1][1] = yEnd;

        int x = xEnd;
        int y = yEnd;
        int N = field.length;

        for (int i = res - 2; i >= 0; i --)
        {
            if (x + 1 < N && field[x + 1][y] == i + 1)
            {
                x += 1;
                xyPath[i][0] = x;
                xyPath[i][1] = y;
            } 

            else if (x - 1 >= 0 && field[x - 1][y] == i + 1) 
            {
                x -= 1;
                xyPath[i][0] = x;
                xyPath[i][1] = y;
            }

            else if (y - 1 >= 0 && field[x][y - 1] == i + 1) 
            {
                y -= 1;
                xyPath[i][0] = x;
                xyPath[i][1] = y;
            }

            else if (y + 1 < N && field[x][y + 1] == i + 1) 
            {
                y += 1;
                xyPath[i][0] = x;
                xyPath[i][1] = y;
            }
        }
        return xyPath;
    }


    public static void main(String [] args) {

        int [][] field = {{-1, 0, 0, 0, 0, -1, -1, 0, -1, 0}, {-1, 0, 0, 0, -1, -1, -1, -1, 0, 0}, {-1, 0, 0, 0, 0, 0, -1, 0, -1, 0}, {-1, 0, -1, -1, -1, 0, -1, -1, 0, 0}, {-1, 0, 0, 0, 0, -1, -1, -1, 0, -1}, {-1, 0, 0, 0, 0, -1, -1, 0, -1, 0}, {0, -1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, -1, 0, -1, -1, 0, 0, -1, 0}, {0, 0, 0, -1, -1, 0, 0, -1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
        int res = Steps_Count(field, 0, 2, 8, 8);
        System.out.println(res); 
        Print_Array(field);
        int [][] xyPath = path(field, 8, 8, 19);
        Print_Array(xyPath);      
    }
}
