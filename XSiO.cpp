#include <iostream>
#include <vector>

using namespace std;

enum class Player { None, X, O };

class XSiO {
public:
    XSiO() : board(3, vector<Player>(3, Player::None)), currentPlayer(Player::X), gameOver(false) {}

    void play() {
        while (!gameOver) {
            drawBoard();
            int row, col;
            do {
                cout << "Player " << getPlayerSymbol(currentPlayer) << ", alege randul (1-3) si coloana (1-3): ";
                cin >> row >> col;
            } while (!isValidMove(row - 1, col - 1));
            
            makeMove(row - 1, col - 1);
            if (checkWin()) {
                drawBoard();
                cout << "Player " << getPlayerSymbol(currentPlayer) << " wins!" << endl;
                gameOver = true;
            } else if (checkDraw()) {
                drawBoard();
                cout << "Egalitate!" << endl;
                gameOver = true;
            } else {
                currentPlayer = (currentPlayer == Player::X) ? Player::O : Player::X;
            }
        }
    }

private:
    vector<vector<Player>> board;
    Player currentPlayer;
    bool gameOver;

    void drawBoard() const {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                cout << " " << getPlayerSymbol(board[i][j]) << " ";
                if (j < 2) cout << "|";
            }
            cout << endl;
            if (i < 2) cout << "-----------" << endl;
        }
    }

    char getPlayerSymbol(Player player) const {
        switch (player) {
            case Player::X: return 'X';
            case Player::O: return 'O';
            default: return ' ';
        }
    }

    bool isValidMove(int row, int col) const {
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            cout << "Mutare invalida. Randul si coloana intre 1-3." << endl;
            return false;
        }

        if (board[row][col] != Player::None) {
            cout << "Mutare invalida. Celula este ocupata." << endl;
            return false;
        }

        return true;
    }

    void makeMove(int row, int col) {
        board[row][col] = currentPlayer;
    }

    bool checkWin() const {
        for (int i = 0; i < 3; ++i) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) return true;
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) return true;
        }
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) return true;
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) return true;
        return false;
    }

    bool checkDraw() const {
        for (const auto& row : board) {
            for (const auto& cell : row) {
                if (cell == Player::None) return false;
            }
        }
        returntrue;
    }
};

int main() {
    XSiO game;
    game.play();

    return 0;
}
